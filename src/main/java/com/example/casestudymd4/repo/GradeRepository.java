package com.example.casestudymd4.repo;

import com.example.casestudymd4.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);

    Grade findByStudentIdAndSubject(Long studentId, String subject);
}
