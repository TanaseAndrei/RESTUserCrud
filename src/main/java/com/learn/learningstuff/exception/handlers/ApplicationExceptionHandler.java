package com.learn.learningstuff.exception.handlers;

import com.learn.learningstuff.dto.exceptions.ExceptionDto;
import com.learn.learningstuff.dto.exceptions.MethodArgumentExceptionDto;
import com.learn.learningstuff.exception.exceptions.AlreadyExistsException;
import com.learn.learningstuff.exception.exceptions.NotFoundException;
import com.learn.learningstuff.utils.mapper.ExceptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ExceptionDto> handleException(NotFoundException notFoundException) {
        ExceptionDto exceptionDTO = ExceptionMapper.exceptionToExceptionDto(notFoundException, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<List<MethodArgumentExceptionDto>> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        List<MethodArgumentExceptionDto> exceptionDtoList = ExceptionMapper.methodArgumentExceptionsToMethodArgumentExceptionDtoList(methodArgumentNotValidException);
        return new ResponseEntity<>(exceptionDtoList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<ExceptionDto> handleException(AlreadyExistsException alreadyExistsException){
        ExceptionDto exceptionDto = ExceptionMapper.exceptionToExceptionDto(alreadyExistsException, HttpStatus.CONFLICT);
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }
}
