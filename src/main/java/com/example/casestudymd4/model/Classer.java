
package com.example.casestudymd4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
@Entity
public class Classer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private Long id;

    @OneToMany(mappedBy = "classer")
    private List<Student> students;

    @Column(nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

}