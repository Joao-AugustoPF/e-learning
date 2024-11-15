package com.example.e_learning_api.domain.repository;

import com.example.e_learning_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Método para encontrar um usuário pelo e-mail
    Optional<User> findByEmail(String email);

    // Método para verificar se um e-mail já está registrado
    boolean existsByEmail(String email);
}