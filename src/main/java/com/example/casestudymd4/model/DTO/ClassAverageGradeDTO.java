package com.example.casestudymd4.model.DTO;

public class ClassAverageGradeDTO {
    private Long classId;
    private String className;
    private double averageGrade;

    public ClassAverageGradeDTO(Long classId, String className, double averageGrade) {
        this.classId = classId;
        this.className = className;
        this.averageGrade = averageGrade;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}

