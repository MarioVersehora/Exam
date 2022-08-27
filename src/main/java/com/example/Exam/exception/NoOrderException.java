package com.example.Exam.exception;


public class NoOrderException extends Exception {

    private String message;

    public NoOrderException(String message) {
        this.message = message;
    }

    public String toString() {
        return "NoOrderException Occured : " + message;
    }
}
