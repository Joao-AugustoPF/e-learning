package com.example.e_learning_api.api.dto;

public class CourseResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String instructor;
    private Double price;

    // Construtor
    public CourseResponseDTO(Long id, String name, String description, String instructor, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.price = price;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}