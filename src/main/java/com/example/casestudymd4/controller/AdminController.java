package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.DTO.ClassAverageGradeDTO;
import com.example.casestudymd4.model.DTO.TeacherStudentCountDTO;
//import com.example.casestudymd4.service.ClassService;
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

//    @Autowired
//    private ClassService classService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/students-per-teacher")
    public ResponseEntity<List<TeacherStudentCountDTO>> getStudentsPerTeacherStatistics() {
        List<TeacherStudentCountDTO> result = userService.countStudentsPerTeacher();
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/admin/statistics/average-grades-per-class")
//    public ResponseEntity<List<ClassAverageGradeDTO>> getClassAverageGrades() {
//        List<ClassAverageGradeDTO> result = classService.getClassAverageGrades();
//        return ResponseEntity.ok(result);
//    }
}

