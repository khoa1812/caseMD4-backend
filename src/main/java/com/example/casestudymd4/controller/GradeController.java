package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradeByStudentId(@PathVariable Long student_Id) {
        List<Grade> grades = gradeService.getGradeByStudentId(student_Id);
        if (grades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(grades);
    }
}