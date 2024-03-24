package com.lab9.Degree;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DegreeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DegreeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String degreeNotFoundHandler(DegreeNotFoundException ex) {
        return ex.getMessage();
    }
}
