package ro.fasttrackit.salarizare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.fasttrackit.salarizare.exceptions.ApiError;
import ro.fasttrackit.salarizare.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class SalaryControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiError handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ApiError(1, ex.getMessage());
    }
}
