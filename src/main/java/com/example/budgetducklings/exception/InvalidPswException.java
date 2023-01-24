package com.example.budgetducklings.exception;

public class InvalidPswException extends RuntimeException {
    private String name;

    public InvalidPswException(String message, String name) {
        super(message);

        this.name = name;
    }


    public String getName() {
        return name;
    }
}

