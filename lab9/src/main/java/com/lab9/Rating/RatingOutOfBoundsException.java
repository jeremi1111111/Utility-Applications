package com.lab9.Rating;

public class RatingOutOfBoundsException extends RuntimeException{
    public RatingOutOfBoundsException() {
        super("Rating is out of bounds.");
    }
}
