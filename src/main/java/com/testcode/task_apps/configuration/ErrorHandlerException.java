package com.testcode.task_apps.configuration;

import com.testcode.task_apps.model.ErrorMessage;
import lombok.Getter;

@Getter
public class ErrorHandlerException extends RuntimeException{
    private final ErrorMessage error;
    public ErrorHandlerException(ErrorMessage error) {
        super(error.getMessage());
        this.error = error;
    }
}
