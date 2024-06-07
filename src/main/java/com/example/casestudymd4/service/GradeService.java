package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public void updateGrade(Long studentId, String subject, double theoretical, double practical) {
        Grade grade = gradeRepository.findByStudentIdAndSubject(studentId, subject);
        grade.setTheoretical(theoretical);
        grade.setPractical(practical);
        grade.setAverage(theoretical);
        gradeRepository.save(grade);
    }
}