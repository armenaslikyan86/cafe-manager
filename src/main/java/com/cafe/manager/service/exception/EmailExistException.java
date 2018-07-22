package com.cafe.manager.service.exception;

public class EmailExistException extends RuntimeException {

    public EmailExistException() {
        super("Email is already existing");
    }
}
