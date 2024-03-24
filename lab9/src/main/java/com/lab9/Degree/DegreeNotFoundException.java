package com.lab9.Degree;

public class DegreeNotFoundException extends RuntimeException {
    DegreeNotFoundException(Integer id) {
        super("Could not find degree " + id);
    }
}
