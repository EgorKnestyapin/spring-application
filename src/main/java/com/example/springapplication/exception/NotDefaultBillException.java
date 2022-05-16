package com.example.springapplication.exception;

public class NotDefaultBillException extends RuntimeException {

    public NotDefaultBillException(String message) {
        super(message);
    }
}
