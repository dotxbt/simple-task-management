# Simple Task Management Apps API

### Build image and run the program as docker container - include update program
```bash
docker-compose up -d --build
```

### Stop the program
```bash
docker-compose down
```

### Stop and remove the container and  the database volume
```bash
docker-compose down -v
```

# API Docs
## User
Register User
```bash
curl -X POST http://localhost:9696/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email": "admin@example.com", "password": "admin123", "role":"CUSTOMER"}'
```

Login User
```bash
curl -X POST http://localhost:9696/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email": "admin@example.com", "password": "admin123"}'
```

## Task
Create Task
```bash
curl -X POST http://localhost:9696/task \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE" \
  -d '{"title": "Hello World", "content": "Lorem ipsum. dolor sit amet.....", "user_id":1}'
```


Get All Tasks
```bash
curl http://localhost:9696/task \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE"
```

Get Only Completed Tasks
```bash
curl "http://localhost:9696/task?complete=true" \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE"
```
Get Only Incomplete Tasks
```bash
curl "http://localhost:9696/task?complete=false" \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE"
```

Update Task
```bash
curl -X PUT http://localhost:9696/task \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE" \
  -d '{"id": 1, "title": "Hello World", "content": "Lorem ipsum. dolor sit amet.....", "completed": true, "user_id":1}'
```

Get Only Incomplete Tasks
```bash
curl -X DELETE http://localhost:9696/task/2 \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE"
```
## Example from client API
```bash
curl http://localhost:9696/posts \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbEBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyMzA1MCwiZXhwIjoxNzQ3ODA5NDUwfQ.tZ_W4iopxPeSxH8epk5DrRC81zC3Vq68-9nwtYbN1tE"
```

## Function Count Integer API
```bash
curl -X POST http://localhost:9696/counter/without-collection \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyNjAzMywiZXhwIjoxNzQ3ODEyNDMzfQ.vv_RxIlO8et-hiz-iziTrhHXbIAV7hASwIIG49nXSi8" \
  -d '{"data": [1,2,3,4,5,6,7,8,9,10,12,121,3234,2424,5252]}'
```
```bash
curl -X POST http://localhost:9696/counter/using-collection \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBleGFtcGxlLmNvbSIsImlhdCI6MTc0NzcyNjAzMywiZXhwIjoxNzQ3ODEyNDMzfQ.vv_RxIlO8et-hiz-iziTrhHXbIAV7hASwIIG49nXSi8" \
  -d '{"data": [1,2,3,4,5,6,7,8,9,10,12,121,3234,2424,5252]}'
```