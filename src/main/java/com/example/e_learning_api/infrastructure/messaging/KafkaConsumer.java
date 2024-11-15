package com.example.e_learning_api.infrastructure.messaging;

import com.example.e_learning_api.application.event.CourseCreatedEvent;
import com.example.e_learning_api.application.event.UserEnrolledEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    // Listener para eventos de criação de curso
    @KafkaListener(topics = "course-events", groupId = "elearning-group")
    public void consumeCourseCreatedEvent(CourseCreatedEvent event) {
        System.out.println("Evento de curso recebido: " + event);
        // Lógica para processar o evento de curso aqui
    }

    // Listener para eventos de matrícula de usuário
    @KafkaListener(topics = "enrollment-events", groupId = "elearning-group")
    public void consumeUserEnrolledEvent(UserEnrolledEvent event) {
        System.out.println("Evento de matrícula recebido: " + event);
        // Lógica para processar o evento de matrícula aqui
    }
}
