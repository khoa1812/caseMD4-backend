package com.example.casestudymd4.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classId;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

}
