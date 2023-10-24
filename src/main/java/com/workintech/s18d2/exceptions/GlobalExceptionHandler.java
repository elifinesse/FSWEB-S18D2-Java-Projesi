package com.workintech.s18d2.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(plantException.getMessage(), plantException.getHttpStatus(), LocalDateTime.now());
        return new ResponseEntity<PlantErrorResponse>(plantErrorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<PlantErrorResponse>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().
            stream().map(error -> { Map<String, String> errorMap = new HashMap<>();
            errorMap.put(error.getField(), error.getDefaultMessage());
            return errorMap;})
            .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }

}
