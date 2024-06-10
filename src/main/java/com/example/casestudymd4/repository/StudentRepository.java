package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClasserId(Long classId);
    List<Student> findByClasserIdAndStatus(Long classId, StudentStatus status);
}

