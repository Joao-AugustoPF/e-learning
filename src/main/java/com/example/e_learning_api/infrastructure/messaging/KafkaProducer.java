package com.example.e_learning_api.infrastructure.messaging;

import com.example.e_learning_api.application.event.CourseCreatedEvent;
import com.example.e_learning_api.application.event.UserEnrolledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String COURSE_TOPIC = "course-events";
    private static final String ENROLLMENT_TOPIC = "enrollment-events";

    // Método para enviar eventos de criação de curso
    public void sendCourseCreatedEvent(CourseCreatedEvent event) {
        kafkaTemplate.send(COURSE_TOPIC, event);
        System.out.println("Evento de curso enviado: " + event);
    }

    // Método para enviar eventos de matrícula de usuário
    public void sendUserEnrolledEvent(UserEnrolledEvent event) {
        kafkaTemplate.send(ENROLLMENT_TOPIC, event);
        System.out.println("Evento de matrícula enviado: " + event);
    }
}
