package com.example.e_learning_api.domain.exception;

public class UserNotFoundException extends RuntimeException {

    // Construtor padrão
    public UserNotFoundException() {
        super("Usuário não encontrado.");
    }

    // Construtor com mensagem personalizada
    public UserNotFoundException(String message) {
        super(message);
    }
}