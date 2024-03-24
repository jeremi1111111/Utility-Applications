package com.lab9.Rating;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RatingOutOfBoundsAdvice {
    @ResponseBody
    @ExceptionHandler(RatingOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String RatingOutOfBoundsHandler(RatingOutOfBoundsException ex) {
        return ex.getMessage();
    }
}
