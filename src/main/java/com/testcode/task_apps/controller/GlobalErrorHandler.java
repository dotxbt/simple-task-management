package com.testcode.task_apps.controller;

import com.testcode.task_apps.configuration.ErrorHandlerException;
import com.testcode.task_apps.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler({RuntimeException.class, ErrorHandlerException.class, Exception.class})
    public ResponseEntity<Map<String, String>> errorHandler(Exception ex, WebRequest request) {
        ErrorMessage error = ErrorMessage.builder().build();

        if (ex instanceof ErrorHandlerException) {
            error = ((ErrorHandlerException) ex).getError();
        } else {
            error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            error.setMessage("Ups! terjadi masalah...Mohon menunggu beberapa saat lalu mencoba kembali atau menghubungi Customer Service");
        }
        error.setPath(request.getDescription(false).replace("uri=", ""));
        return ResponseEntity.status(error.getStatus()).body(error.getBody());
    }
}
