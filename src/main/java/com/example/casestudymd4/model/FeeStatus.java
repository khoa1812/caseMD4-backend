package com.example.casestudymd4.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class FeeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeStatusId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private FeeStatusEnum status;

}
