package com.lab9.Rating;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(Integer id) {
        super("Could not find rating " + id);
    }
}
