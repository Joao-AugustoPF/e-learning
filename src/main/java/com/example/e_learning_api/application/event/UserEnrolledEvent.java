package com.example.e_learning_api.application.event;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserEnrolledEvent implements Serializable {

    private Long enrollmentId;
    private Long userId;
    private String userEmail;
    private Long courseId;
    private String courseName;
    private LocalDateTime enrollmentDate;

    // Construtor vazio
    public UserEnrolledEvent() {
    }

    // Construtor completo
    public UserEnrolledEvent(Long enrollmentId, Long userId, String userEmail, Long courseId, String courseName, LocalDateTime enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.userId = userId;
        this.userEmail = userEmail;
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters e Setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    @Override
    public String toString() {
        return "UserEnrolledEvent{" +
                "enrollmentId=" + enrollmentId +
                ", userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
