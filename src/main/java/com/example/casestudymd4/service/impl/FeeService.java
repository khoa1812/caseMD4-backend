package com.example.casestudymd4.service.impl;

import com.example.casestudymd4.model.FeeStatus;
import com.example.casestudymd4.service.FeeStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService implements FeeStatusService {

    @Override
    public List<FeeStatus> getFeeStatusByStudentId(Long studentId) {
        return null;
    }

    @Override
    public List<FeeStatus> getNextPaymentByStudentId(Long studentId) {
        return null;
    }
}
