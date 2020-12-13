package com.learn.learningstuff.utils.mapper;

import com.learn.learningstuff.dto.exceptions.ExceptionDto;
import com.learn.learningstuff.dto.exceptions.MethodArgumentExceptionDto;
import com.learn.learningstuff.exception.exceptions.ApiServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionMapper {

    private ExceptionMapper(){

    }

    public static <T extends ApiServiceException> ExceptionDto exceptionToExceptionDto(T t, HttpStatus httpStatus) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(t.getMessage());
        exceptionDto.setStatus(httpStatus.value());
        exceptionDto.setTimestamp(LocalDateTime.now());
        return exceptionDto;
    }

    public static <T extends MethodArgumentNotValidException> List<MethodArgumentExceptionDto> methodArgumentExceptionsToMethodArgumentExceptionDtoList(T t) {
        return t
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> {
                    MethodArgumentExceptionDto methodArgumentExceptionDto = new MethodArgumentExceptionDto();
                    methodArgumentExceptionDto.setMessage(objectError.getDefaultMessage());
                    methodArgumentExceptionDto.setTimestamp(LocalDateTime.now());
                    return methodArgumentExceptionDto;
                })
                .collect(Collectors.toList());
    }
}
