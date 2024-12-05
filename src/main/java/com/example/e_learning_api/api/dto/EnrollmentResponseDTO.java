package com.example.e_learning_api.api.dto;

import com.example.e_learning_api.domain.model.Enrollment;

import java.time.LocalDateTime;

public class EnrollmentResponseDTO {

    private Long id;
    private Long courseId;
    private String courseName;
    private LocalDateTime enrollmentDate;
    private Boolean completed;

    // Construtor que aceita um objeto Enrollment
    public EnrollmentResponseDTO(Enrollment enrollment) {
        this.id = enrollment.getId();
        this.courseId = enrollment.getCourse().getId();
        this.courseName = enrollment.getCourse().getName();
        this.enrollmentDate = enrollment.getEnrollmentDate();
        this.completed = enrollment.getCompleted();
    }

    // Getters e setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
