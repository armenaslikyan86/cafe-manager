package com.cafe.manager.service.exception;

public class EmailExistException extends Throwable {
    public EmailExistException(String email_already_exists) {
        throw new RuntimeException(email_already_exists);
    }
}
