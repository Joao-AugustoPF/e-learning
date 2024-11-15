package com.example.e_learning_api.application.service;

import com.example.e_learning_api.domain.exception.CourseNotFoundException;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Método para listar todos os cursos
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Método para buscar um curso por ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Curso com ID " + id + " não encontrado."));
    }

    // Método para criar um novo curso
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Método para atualizar um curso existente
    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = getCourseById(id);
        existingCourse.setName(updatedCourse.getName());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setInstructor(updatedCourse.getInstructor());
        existingCourse.setPrice(updatedCourse.getPrice());
        return courseRepository.save(existingCourse);
    }

    // Método para deletar um curso
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}