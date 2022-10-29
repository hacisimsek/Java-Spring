package com.sprigbootexecptionhandling.sprigbootexecptionhandling.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String name) {
        super("Entity not found: " + name);
    }
}
