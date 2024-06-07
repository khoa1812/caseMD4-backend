package com.example.casestudymd4.repo;

import com.example.casestudymd4.model.FeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeStatusRepository extends JpaRepository<FeeStatus, Long> {
    List<FeeStatus> findByStudentId(Long studentId);
}
