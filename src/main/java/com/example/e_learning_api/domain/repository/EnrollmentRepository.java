package com.example.e_learning_api.domain.repository;

import com.example.e_learning_api.domain.model.Enrollment;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Método para encontrar matrículas por usuário
    List<Enrollment> findByUser(User user);

    // Método para encontrar matrículas por curso
    List<Enrollment> findByCourse(Course course);

    // Método para encontrar uma matrícula específica de um usuário em um curso
    Optional<Enrollment> findByUserAndCourse(User user, Course course);

    // Método customizado para encontrar matrículas pelo ID do usuário
    List<Enrollment> findByUserId(Long userId);

    // Método customizado para encontrar matrículas pelo ID do curso
    List<Enrollment> findByCourseId(Long courseId);
}