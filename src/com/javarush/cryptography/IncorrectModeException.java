package com.javarush.cryptography;

public class IncorrectModeException extends RuntimeException {

    public IncorrectModeException(String errorMessage) {
        super(errorMessage);
    }
}
