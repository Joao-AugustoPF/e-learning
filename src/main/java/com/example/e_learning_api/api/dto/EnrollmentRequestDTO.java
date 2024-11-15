package com.example.e_learning_api.api.dto;

import jakarta.validation.constraints.NotNull;

public class EnrollmentRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long userId;

    @NotNull(message = "O ID do curso é obrigatório.")
    private Long courseId;

    // Getters e Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}