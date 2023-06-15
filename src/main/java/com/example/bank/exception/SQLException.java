package com.example.bank.exception;

public class SQLException extends RuntimeException {
    public SQLException(String message, Throwable cause){
        super(message, cause);
    }

    public SQLException(String message){
        super(message);
    }
}
