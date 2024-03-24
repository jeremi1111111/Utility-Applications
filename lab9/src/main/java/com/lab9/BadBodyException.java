package com.lab9;

public class BadBodyException extends RuntimeException {
    public BadBodyException() {
        super("Can't associate one or more of body parameters to entity.");
    }
}
