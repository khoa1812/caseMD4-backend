package com.example.casestudymd4.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(nullable = false)
    private String subjectName;

}
