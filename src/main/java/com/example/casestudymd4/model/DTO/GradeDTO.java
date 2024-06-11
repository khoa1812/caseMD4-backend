package com.example.casestudymd4.model.DTO;

public class GradeDTO {
    private Long gradeId;
    private String subject;
    private Double theoretical;
    private Double practical;
    private Double average;

    public GradeDTO() {}

    public GradeDTO(Long gradeId, String subject, Double theoretical, Double practical, Double average) {
        this.gradeId = gradeId;
        this.subject = subject;
        this.theoretical = theoretical;
        this.practical = practical;
        this.average = average;
    }
}
