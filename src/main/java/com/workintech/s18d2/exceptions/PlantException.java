package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PlantException extends RuntimeException{
    private HttpStatus httpStatus;
    public PlantException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    
}
