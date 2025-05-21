package com.testcode.task_apps.helper;

import com.testcode.task_apps.configuration.ErrorHandlerException;
import com.testcode.task_apps.model.ErrorMessage;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Properties;

@Data
public class EnvResource {
    private Properties env;
    public EnvResource(){
        Resource resource = new ClassPathResource("/env.properties");
        try {
            this.env = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.FAILED_DEPENDENCY)
                    .path("*")
                    .message("env.properties not found!")
                    .build());
        }
    }
    public String get(String key) {
       return env.getProperty(key);
    }
}
