package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Classer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasserRepository extends JpaRepository<Classer, Long> {
    List<Classer> findByTeacherId(Long teacherId);
}
