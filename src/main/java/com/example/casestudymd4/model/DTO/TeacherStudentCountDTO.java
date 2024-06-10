
package com.example.casestudymd4.model.DTO;

public class TeacherStudentCountDTO {
    private Long teacherId;
    private String teacherName;
    private Long studentCount;

    public TeacherStudentCountDTO(Long teacherId, String teacherName, Long studentCount) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.studentCount = studentCount;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }
}

