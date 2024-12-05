package com.example.e_learning_api.api.controller;

import com.example.e_learning_api.api.dto.CourseDTO;
import com.example.e_learning_api.api.dto.CourseRequestDTO;
import com.example.e_learning_api.api.dto.CourseResponseDTO;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(
            @RequestParam(required = false) String name
    ) {
        List<CourseDTO> courses = courseService.getFilteredCourses(name);
        return ResponseEntity.ok(courses);
    }

    // Endpoint para buscar um curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        CourseResponseDTO response = new CourseResponseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getInstructor(),
                course.getPrice()
        );
        return ResponseEntity.ok(response);
    }

    // Endpoint para criar um novo curso
    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Validated @RequestBody CourseRequestDTO request) {
        Course course = courseService.createCourse(new Course(
                request.getName(),
                request.getDescription(),
                request.getInstructor(),
                request.getPrice()
        ));
        CourseResponseDTO response = new CourseResponseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getInstructor(),
                course.getPrice()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Endpoint para atualizar um curso
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id, @Validated @RequestBody CourseRequestDTO request) {
        Course updatedCourse = courseService.updateCourse(id, new Course(
                request.getName(),
                request.getDescription(),
                request.getInstructor(),
                request.getPrice()
        ));
        CourseResponseDTO response = new CourseResponseDTO(
                updatedCourse.getId(),
                updatedCourse.getName(),
                updatedCourse.getDescription(),
                updatedCourse.getInstructor(),
                updatedCourse.getPrice()
        );
        return ResponseEntity.ok(response);
    }

    // Endpoint para deletar um curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}