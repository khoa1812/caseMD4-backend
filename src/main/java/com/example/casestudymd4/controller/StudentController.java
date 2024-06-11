package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/user/{userId}")
    public List<Student> getStudentsByUserId(@PathVariable Long userId) {
        return studentService.getStudentsByUserId(userId);
    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClassId(@PathVariable Long classId) {
        return studentService.getStudentsByClassId(classId);
    }

    @GetMapping("/status/{status}")
    public List<Student> getStudentsByStatus(@PathVariable StudentStatus status) {
        return studentService.getStudentsByStatus(status);
    }

    @GetMapping("/{studentId}")
    public List<StudentDTO> getStudentByUser(@PathVariable Long studentId) {
        return studentService.findAllStudentsWithUser(studentId);
    }
}