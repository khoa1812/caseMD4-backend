package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClasserId(Long classId);
    List<Student> findByClasserIdAndStatus(Long classId, StudentStatus status);

    List<Student> findByUserId(Long userId);

    List<Student> findByStatus(StudentStatus status);

    List<Student> findAllByUserId(Long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM Student s JOIN User u ON s.user_id = :uid;")
//    List<StudentDTO> findAllStudentsWithUser(@Param("uid") Long uId);
}

