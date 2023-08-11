package com.boombox.exceptions.general;

public class EntityCouldNotBeCreated extends RuntimeException {
    public EntityCouldNotBeCreated(String message) {
        super(message);
    }

    public EntityCouldNotBeCreated(String message, Throwable cause) {
        super(message, cause);
    }
}
