package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClasserId(Long classId);
    List<Student> findByClasserIdAndStatus(Long classId, StudentStatus status);

    List<Student> findByUserId(Long userId);

    List<Student> findByStatus(StudentStatus status);

    @Query(nativeQuery = true, value = "SELECT s.student_id, u.full_name, u.email, u.address, u.date_of_birth " + "FROM Students s " + "JOIN Users u ON s.user_id = u.user_id")
    List<StudentDTO> findAllStudentsWithUser();
}

