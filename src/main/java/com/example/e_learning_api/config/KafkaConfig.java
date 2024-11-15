package com.example.e_learning_api.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    // Configuração para criar o tópico "course-events"
    @Bean
    public NewTopic courseEventsTopic() {
        return TopicBuilder.name("course-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

    // Configuração para criar o tópico "enrollment-events"
    @Bean
    public NewTopic enrollmentEventsTopic() {
        return TopicBuilder.name("enrollment-events")
                .partitions(3)
                .replicas(1)
                .build();
    }
}