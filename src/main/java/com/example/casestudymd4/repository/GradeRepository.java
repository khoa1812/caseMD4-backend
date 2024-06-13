package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

//    @Query("SELECT new com.example.casestudymd4.model.DTO.Grade(g.gradeId, g.subject, g.theoretical, g.practical, g.average) " +
//            "FROM Grade g WHERE g.student.id = :studentId")
//    List<Grade> findGradesByStudentId(Long studentId);
    Iterable<Grade> findGradeByStudentStudentId(Long studentId);
}


