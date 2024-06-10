package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.DTO.TeacherStudentCountDTO;
import com.example.casestudymd4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/students-per-teacher")
    public ResponseEntity<List<TeacherStudentCountDTO>> getStudentsPerTeacherStatistics() {
        List<TeacherStudentCountDTO> result = userService.countStudentsPerTeacher();
        return ResponseEntity.ok(result);
    }
}

