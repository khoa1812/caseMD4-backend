package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Grade;
import java.util.List;

public interface GradeService {
    List<Grade> getGradeByStudentId(Long studentId);
}
