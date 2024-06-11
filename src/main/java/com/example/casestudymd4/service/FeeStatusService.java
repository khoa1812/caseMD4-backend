package com.example.casestudymd4.service;

import com.example.casestudymd4.model.FeeStatus;
import java.util.List;

public interface FeeStatusService {
    List<FeeStatus> getFeeStatusByStudentId(Long studentId);
    List<FeeStatus> getNextPaymentByStudentId(Long studentId);
}
