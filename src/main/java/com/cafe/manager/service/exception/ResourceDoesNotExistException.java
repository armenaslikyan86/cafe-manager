package com.cafe.manager.service.exception;

public class ResourceDoesNotExistException extends RuntimeException {

    public ResourceDoesNotExistException(final String message) {
        super(message);
    }
}
