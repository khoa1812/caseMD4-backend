package com.example.casestudymd4.model.DTO;

import com.example.casestudymd4.model.StudentStatus;

public class StudentDTO {

    private Long studentId;
    private Long userId;
    private Long classId;
    private StudentStatus status;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateofbirth;

    public StudentDTO(Long studentId, Long userId, Long classId, StudentStatus status, String fullName, String email, String phoneNumber, String address, String dateOfBirth) {
        this.studentId = studentId;
        this.userId = userId;
        this.classId = classId;
        this.status = status;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateofbirth = dateOfBirth;
    }
}

