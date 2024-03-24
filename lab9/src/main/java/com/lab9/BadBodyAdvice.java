package com.lab9;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BadBodyAdvice {
    @ResponseBody
    @ExceptionHandler(BadBodyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String BadBodyHandler(BadBodyException ex) {
        return ex.getMessage();
    }
}
