package com.example.e_learning_api.domain.repository;

import com.example.e_learning_api.domain.model.Enrollment;
import com.example.e_learning_api.domain.model.Course;
import com.example.e_learning_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourse(Course course);

    Optional<Enrollment> findByUserAndCourse(User user, Course course);

    List<Enrollment> findByUserId(Long userId);
}