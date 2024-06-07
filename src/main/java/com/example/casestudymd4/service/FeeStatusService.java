package com.example.casestudymd4.service;

import com.example.casestudymd4.model.FeeStatus;
import com.example.casestudymd4.repo.FeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeStatusService {

    @Autowired
    private FeeStatusRepository feeStatusRepository;

    public List<FeeStatus> getFeeStatusByStudentId(Long studentId) {
        return feeStatusRepository.findByStudentId(studentId);
    }
}

