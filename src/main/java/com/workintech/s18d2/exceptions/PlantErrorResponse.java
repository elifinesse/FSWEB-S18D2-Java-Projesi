package com.workintech.s18d2.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantErrorResponse {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDate;
}
