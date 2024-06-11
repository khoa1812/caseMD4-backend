package com.example.casestudymd4.service.impl;

import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.repository.GradeRepository;
import com.example.casestudymd4.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getGradeByStudentId(Long studentId) {
        return null;
    }

    public GradeRepository getGradeRepository() {
        return gradeRepository;
    }

    public void setGradeRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
}

