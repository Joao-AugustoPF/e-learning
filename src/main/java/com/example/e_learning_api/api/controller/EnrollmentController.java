package com.example.e_learning_api.api.controller;

import com.example.e_learning_api.api.dto.EnrollmentRequestDTO;
import com.example.e_learning_api.domain.model.Enrollment;
import com.example.e_learning_api.application.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Endpoint para matricular um usuário em um curso
    @PostMapping
    public ResponseEntity<Enrollment> enrollUserInCourse(@Validated @RequestBody EnrollmentRequestDTO request) {
        Enrollment enrollment = enrollmentService.enrollUserInCourse(request.getUserId(), request.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    // Endpoint para listar todas as matrículas de um usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Enrollment>> getUserEnrollments(@PathVariable Long userId) {
        return ResponseEntity.ok(enrollmentService.getUserEnrollments(userId));
    }

    // Endpoint para listar todas as matrículas de um curso
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getCourseEnrollments(@PathVariable Long courseId) {
        return ResponseEntity.ok(enrollmentService.getCourseEnrollments(courseId));
    }

    // Endpoint para marcar uma matrícula como concluída
    @PutMapping("/{enrollmentId}/complete")
    public ResponseEntity<Enrollment> completeEnrollment(@PathVariable Long enrollmentId) {
        Enrollment enrollment = enrollmentService.completeEnrollment(enrollmentId);
        return ResponseEntity.ok(enrollment);
    }
}