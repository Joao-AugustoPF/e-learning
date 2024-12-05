package com.example.e_learning_api.application.service;

import com.example.e_learning_api.api.dto.CourseDTO;
import com.example.e_learning_api.domain.exception.CourseNotFoundException;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getFilteredCourses(String name) {
        List<Course> courses;

        if (name != null) {
            courses = courseRepository.findByNameContaining(name);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getPrice(),
                        course.getInstructor()
                ))
                .collect(Collectors.toList());
    }



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