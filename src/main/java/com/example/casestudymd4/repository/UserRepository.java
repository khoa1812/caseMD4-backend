package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.DTO.TeacherStudentCountDTO;
import com.example.casestudymd4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
//    Iterable<User> findAllByRolesName(String roleName);
//    Iterable<User> findByNameContainingAndRolesIdNot(String name, Long User);
//    Iterable<User> findByUsernameContainingAndRolesIdNot(String username, Long User);
//    Iterable<User> findByStatusAndRolesIdNot(String status, Long id);;
//    Iterable<User>findByNameContainingAndUsernameContainingAndRolesIdNot(String name, String username, Long User);
//    Iterable<User> findByRolesIdNot(Long User);

    @Query("SELECT new com.example.casestudymd4.model.DTO.TeacherStudentCountDTO(t.id, t.fullName, COUNT(s)) " +
            "FROM Class c JOIN c.teacher t JOIN c.students s " +
            "GROUP BY t.id, t.fullName")
    List<TeacherStudentCountDTO> countStudentsPerTeacher();

}
