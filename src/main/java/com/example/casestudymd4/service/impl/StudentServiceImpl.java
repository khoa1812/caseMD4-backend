package com.example.casestudymd4.service.impl;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.repository.StudentRepository;
import com.example.casestudymd4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudentsByUserId(Long userId) {
        return studentRepository.findByUserId(userId);
    }

    @Override
    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClasserId(classId);
    }

    @Override
    public List<Student> getStudentsByStatus(StudentStatus status) {
        return studentRepository.findByStatus(status);
    }

    @Override
    public List<StudentDTO> findAllStudentsWithUser(Long studentId) {
//        return studentRepository.findAllStudentsWithUser(studentId);
        return null;
    }

    @Override
    public List<Student> getStudentByUid(Long id) {
        return studentRepository.findAllByUserId(id);
    }


}
