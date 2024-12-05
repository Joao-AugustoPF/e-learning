package com.example.e_learning_api.application.service;


import com.example.e_learning_api.domain.exception.UserNotFoundException;
import com.example.e_learning_api.domain.model.Log;
import com.example.e_learning_api.domain.model.User;
import com.example.e_learning_api.domain.repository.LogRepository;
import com.example.e_learning_api.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public UserService(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    // Método para listar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para buscar um usuário por ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não encontrado."));
    }

    // Método para buscar um usuário por e-mail
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário com e-mail " + email + " não encontrado."));
    }

    // Método para criar um novo usuário
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("E-mail já está registrado.");
        }

        User createdUser = userRepository.save(user);

        Log log = new Log(
                "Usuário criado: " + createdUser.getName() + " (E-mail: " + createdUser.getEmail() + ")"
        );
        logRepository.save(log);

        return userRepository.save(user);
    }

    // Método para atualizar os dados de um usuário
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);

        StringBuilder logMessage = new StringBuilder("Usuário com ID " + id + " atualizado. Alterações: ");
        if (!existingUser.getName().equals(updatedUser.getName())) {
            logMessage.append("Nome alterado de '").append(existingUser.getName()).append("' para '").append(updatedUser.getName()).append("'. ");
        }
        if (!existingUser.getPassword().equals(updatedUser.getPassword())) {
            logMessage.append("Senha alterada. ");
        }
        if (!existingUser.getRole().equals(updatedUser.getRole())) {
            logMessage.append("Função alterada de '").append(existingUser.getRole()).append("' para '").append(updatedUser.getRole()).append("'. ");
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());

        Log log = new Log(logMessage.toString());
        logRepository.save(log);

        return userRepository.save(existingUser);
    }

    // Método para deletar um usuário
    public void deleteUser(Long id) {
        User user = getUserById(id);

        Log log = new Log(
                "Usuário deletado: " + user.getName() + " (E-mail: " + user.getEmail() + ")"
        );
        logRepository.save(log);

        userRepository.delete(user);
    }
}