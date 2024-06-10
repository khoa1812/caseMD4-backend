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
    @JoinColumn(name = "classer_id")
    private Classer classer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "class_id")
//    private Classer classId;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

}
