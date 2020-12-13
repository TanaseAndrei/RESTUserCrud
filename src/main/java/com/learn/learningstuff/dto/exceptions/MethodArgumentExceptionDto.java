package com.learn.learningstuff.dto.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MethodArgumentExceptionDto {
    private String message;
    private LocalDateTime timestamp;
}
