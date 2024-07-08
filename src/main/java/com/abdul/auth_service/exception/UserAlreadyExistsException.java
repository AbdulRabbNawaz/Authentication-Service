package com.abdul.auth_service.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException{
    private String errorCode;

    public UserAlreadyExistsException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
