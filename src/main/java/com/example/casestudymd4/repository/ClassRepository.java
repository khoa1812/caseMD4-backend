package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Classer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Classer, Long> {
}
