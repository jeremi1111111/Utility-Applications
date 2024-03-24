package com.lab9.Student;

public class ExistingStudentException extends RuntimeException {
    ExistingStudentException() {
        super("Student already attends to the subject.");
    }
}
