package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Grade;
import java.util.List;

public interface GradeService {
    Iterable<Grade> getGradeByStudentId(Long studentId);
}
