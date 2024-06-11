package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Classer;
import com.example.casestudymd4.model.DTO.ListClassDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClasserRepository extends JpaRepository<Classer, Long> {
//    List<Classer> findByTeacherId(Long teacherId);

    @Query(nativeQuery = true,value = "select class_id as id,class_name as name from classer")
    Iterable<ListClassDTO> findClassByTeacherId();
}
