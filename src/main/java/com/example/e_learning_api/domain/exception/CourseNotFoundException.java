package com.example.e_learning_api.domain.exception;

public class CourseNotFoundException extends RuntimeException {

    // Construtor padrão
    public CourseNotFoundException() {
        super("Curso não encontrado.");
    }

    // Construtor com mensagem personalizada
    public CourseNotFoundException(String message) {
        super(message);
    }
}