package com.example.e_learning_api.api.controller;

import com.example.e_learning_api.api.dto.UserRequestDTO;
import com.example.e_learning_api.domain.model.User;
import com.example.e_learning_api.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Endpoint para buscar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody UserRequestDTO request) {
        User user = new User(request.getEmail(), request.getName(), request.getPassword(), request.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    // Endpoint para atualizar um usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Validated @RequestBody UserRequestDTO request) {
        User updatedUser = new User(request.getEmail(), request.getName(), request.getPassword(), request.getRole());
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    // Endpoint para deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}