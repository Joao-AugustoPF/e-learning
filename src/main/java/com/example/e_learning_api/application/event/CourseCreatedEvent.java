package com.example.e_learning_api.application.event;

import java.io.Serializable;

public class CourseCreatedEvent implements Serializable {

    private Long courseId;
    private String courseName;
    private String instructor;
    private Double price;

    // Construtor vazio
    public CourseCreatedEvent() {
    }

    // Construtor completo
    public CourseCreatedEvent(Long courseId, String courseName, String instructor, Double price) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.price = price;
    }

    // Getters e Setters
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CourseCreatedEvent{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", price=" + price +
                '}';
    }
}