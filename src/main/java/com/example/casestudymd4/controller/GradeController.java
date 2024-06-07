package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Grade>> getGrades(@PathVariable Long id) {
        List<Grade> grades = gradeService.getGradesByStudentId(id);
        return ResponseEntity.ok(grades);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateGrade(@RequestParam Long studentId, @RequestParam String subject,
                                            @RequestParam double theoretical, @RequestParam double practical) {
        gradeService.updateGrade(studentId, subject, theoretical, practical);
        return ResponseEntity.noContent().build();
    }
}
