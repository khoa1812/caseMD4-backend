package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.DTO.ClassAverageGradeDTO;
import com.example.casestudymd4.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    @Query("SELECT new com.example.casestudymd4.model.DTO.ClassAverageGradeDTO(c.classId, c.className, AVG(g.average)) FROM Class c JOIN c.students s JOIN s.grades g GROUP BY c.classId, c.className")
    List<ClassAverageGradeDTO> findClassAverageGrades();
}

