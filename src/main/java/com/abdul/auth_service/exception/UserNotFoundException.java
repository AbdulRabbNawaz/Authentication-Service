package com.abdul.auth_service.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
    private String errorCode;

    public UserNotFoundException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
