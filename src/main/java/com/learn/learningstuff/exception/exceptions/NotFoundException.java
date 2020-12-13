package com.learn.learningstuff.exception.exceptions;

public class NotFoundException extends ApiServiceException{
    public NotFoundException(String message){
        super(message);
    }
}
