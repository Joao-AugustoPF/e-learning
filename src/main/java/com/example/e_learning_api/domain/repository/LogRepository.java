package com.example.e_learning_api.domain.repository;


import com.example.e_learning_api.domain.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
