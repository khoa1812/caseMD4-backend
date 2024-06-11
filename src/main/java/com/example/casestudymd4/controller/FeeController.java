package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.FeeStatus;
import com.example.casestudymd4.service.FeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fee")
public class FeeController {

    @Autowired
    private FeeStatusService feeStatusService;

    @GetMapping("/student/{studentId}")
    public List<FeeStatus> getFeeStatusByStudentId(@PathVariable Long studentId) {
        return feeStatusService.getFeeStatusByStudentId(studentId);
    }

    @GetMapping("/student/{studentId}/next-payment")
    public List<FeeStatus> getNextPaymentByStudentId(@PathVariable Long studentId) {
        return feeStatusService.getNextPaymentByStudentId(studentId);
    }
}

