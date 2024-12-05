package com.example.e_learning_api.domain.repository;

import com.example.e_learning_api.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Método para encontrar cursos pelo nome (consulta personalizada)
    List<Course> findByNameContainingIgnoreCase(String name);

    List<Course> findByNameContaining(String name);

    // Método para listar cursos por instrutor
    List<Course> findByInstructor(String instructor);
}