package com.example.e_learning_api.api.dto;

public class CourseDTO {
        private final Long id;
        private final String name;
        private final String description;
        private final Double price;
        private final String instructorName;

        public CourseDTO(Long id, String name, String description, Double price, String instructorName) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.instructorName = instructorName;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Double getPrice() {
            return price;
        }

        public String getInstructorName() {
            return instructorName;
        }
}
