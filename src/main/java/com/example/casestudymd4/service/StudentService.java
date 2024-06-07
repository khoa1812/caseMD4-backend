package com.example.casestudymd4.service;

import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.repo.StudentRepository;
import com.example.casestudymd4.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void updateStudentStatus(Long studentId, StudentStatus status) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStatus(status);
        studentRepository.save(student);
    }
}
