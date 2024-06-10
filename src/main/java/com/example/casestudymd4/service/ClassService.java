package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Classer;

import java.util.List;

public interface ClassService {
    List<Classer> getAllClasses();
    Classer addClass(Classer classer);
    void deleteClass(Long classId);
}
