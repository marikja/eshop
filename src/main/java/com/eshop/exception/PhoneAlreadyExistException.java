package com.eshop.exception;

public class PhoneAlreadyExistException extends RuntimeException {

    public PhoneAlreadyExistException(String message) {
        super(message);
    }
}
