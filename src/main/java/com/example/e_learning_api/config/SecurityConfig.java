package com.example.e_learning_api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desabilita o CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // Permite acesso livre às rotas da API
                        .anyRequest().authenticated()           // Exige autenticação para outras rotas
                )
                .httpBasic(Customizer.withDefaults());  // Configura a autenticação HTTP Básica

        return http.build();
    }
}