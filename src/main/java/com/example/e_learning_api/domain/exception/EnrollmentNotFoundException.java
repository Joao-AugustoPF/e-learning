package com.example.e_learning_api.domain.exception;

public class EnrollmentNotFoundException extends RuntimeException {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
}