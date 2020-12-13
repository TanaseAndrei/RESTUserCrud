package com.learn.learningstuff.exception.exceptions;

public class AlreadyExistsException extends ApiServiceException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}
