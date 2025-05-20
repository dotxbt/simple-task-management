# Stage 1: Build the jar
FROM maven:eclipse-temurin AS builder
RUN echo "Make /app directory..."
WORKDIR /app

RUN echo "Copying files..."
COPY . .

RUN echo "Checking dependencies..."
RUN ./mvnw dependency:go-offline

RUN echo "Build *.jar file"
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk

WORKDIR /app

RUN echo "Copying *.jar file to image"
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
RUN echo "DONE : Creating image"