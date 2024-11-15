package com.example.e_learning_api.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourseRequestDTO {

    @NotBlank(message = "O nome do curso é obrigatório.")
    @Size(max = 100, message = "O nome do curso deve ter no máximo 100 caracteres.")
    private String name;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    @NotBlank(message = "O nome do instrutor é obrigatório.")
    private String instructor;

    @NotNull(message = "O preço é obrigatório.")
    private Double price;

    // Getters e Setters
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