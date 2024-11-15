package com.example.e_learning_api.application.service;


import com.example.e_learning_api.domain.exception.UserNotFoundException;
import com.example.e_learning_api.domain.model.User;
import com.example.e_learning_api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        return userRepository.save(user);
    }

    // Método para atualizar os dados de um usuário
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());
        return userRepository.save(existingUser);
    }

    // Método para deletar um usuário
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}