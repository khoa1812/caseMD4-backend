package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/student/{studentId}")
    public List<Grade> getGrades(@PathVariable int studentId) {
        return gradeService.getGradeByStudentId(studentId);
    }
}

