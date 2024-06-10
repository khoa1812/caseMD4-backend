package com.example.casestudymd4.service.impl;

import com.example.casestudymd4.model.Classer;
import com.example.casestudymd4.repository.ClassRepository;
import com.example.casestudymd4.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Classer> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Classer addClass(Classer classer) {
        return classRepository.save(classer);
    }

    @Override
    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }
}
