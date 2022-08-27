package com.example.Exam.exception;

public class NoStoreException extends Exception {

    private String message;

    public NoStoreException(String message) {
        this.message = message;
    }

    public String toString() {
        return "NoStoreException Occured : " + message;
    }
}
