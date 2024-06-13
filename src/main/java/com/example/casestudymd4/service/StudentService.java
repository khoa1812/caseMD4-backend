package com.example.casestudymd4.service;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;

import java.util.List;

public interface StudentService {
    List<Student> getStudentsByUserId(Long userId);

    List<Student> getStudentsByClassId(Long classId);

    List<Student> getStudentsByStatus(StudentStatus status);

    List<StudentDTO> findAllStudentsWithUser(Long studentId);

    List<Student> getStudentByUid(Long id);

}

