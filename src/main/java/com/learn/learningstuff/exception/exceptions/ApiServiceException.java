package com.learn.learningstuff.exception.exceptions;

public class ApiServiceException extends RuntimeException{
    public ApiServiceException(String message){
        super(message);
    }
}
