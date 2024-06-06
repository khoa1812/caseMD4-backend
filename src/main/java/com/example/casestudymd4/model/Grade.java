package com.example.casestudymd4.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private double theoretical;

    @Column(nullable = false)
    private double practical;

    @Column(nullable = false)
    private double average;

}
