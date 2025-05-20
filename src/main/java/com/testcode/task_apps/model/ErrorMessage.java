package com.testcode.task_apps.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private HttpStatus status;
    private String message;
    private String path;
    private String ack;

    public Map<String, String> getBody() {
        Map<String, String> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("title", status.toString());
        if (ack != null) {
            response.put("ack", ack);
        }
        response.put("message", message);
        response.put("path", path);
        return response;
    }
}
