package com.example.e_learning_api.application.service;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.domain.model.Enrollment;
import com.example.e_learning_api.domain.model.User;
import com.example.e_learning_api.domain.repository.EnrollmentRepository;
import com.example.e_learning_api.domain.repository.CourseRepository;
import com.example.e_learning_api.domain.repository.UserRepository;
import com.example.e_learning_api.domain.exception.UserNotFoundException;
import com.example.e_learning_api.domain.exception.CourseNotFoundException;
import com.example.e_learning_api.domain.exception.EnrollmentNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    // Injeção de dependência via construtor
    public EnrollmentService(EnrollmentRepository enrollmentRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    // Método para matricular um usuário em um curso
    public Enrollment enrollUserInCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + userId + " não encontrado."));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso com ID " + courseId + " não encontrado."));

        // Verificar se o usuário já está matriculado no curso
        if (enrollmentRepository.findByUserAndCourse(user, course).isPresent()) {
            throw new IllegalArgumentException("Usuário já está matriculado neste curso.");
        }

        Enrollment enrollment = new Enrollment(user, course, LocalDateTime.now(), false);
        return enrollmentRepository.save(enrollment);
    }

    // Método para listar todas as matrículas de um usuário
    public List<Enrollment> getUserEnrollments(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + userId + " não encontrado."));
        return enrollmentRepository.findByUser(user);
    }

    // Método para listar todas as matrículas de um curso
    public List<Enrollment> getCourseEnrollments(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso com ID " + courseId + " não encontrado."));
        return enrollmentRepository.findByCourse(course);
    }

    // Método para marcar um curso como concluído
    public Enrollment completeEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Matrícula com ID " + enrollmentId + " não encontrada."));
        enrollment.setCompleted(true);
        return enrollmentRepository.save(enrollment);
    }
}