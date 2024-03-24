package com.lab9.Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExistingStudentAdvice {
    @ResponseBody
    @ExceptionHandler(ExistingStudentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String BadBodyHandler(ExistingStudentException ex) {
        return ex.getMessage();
    }
}
