package com.lab9.Student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
        super("Could not find student " + id);
    }
}
