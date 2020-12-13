package com.learn.learningstuff.dto.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ExceptionDto {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
