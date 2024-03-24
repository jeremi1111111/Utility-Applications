package com.lab9.Subject;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(Integer id) {
        super("Could not find subject " + id);
    }
}
