package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping("/update-status")
    public ResponseEntity<Void> updateStudentStatus(@RequestParam Long studentId, @RequestParam StudentStatus status) {
        studentService.updateStudentStatus(studentId, status);
        return ResponseEntity.noContent().build();
    }
}
