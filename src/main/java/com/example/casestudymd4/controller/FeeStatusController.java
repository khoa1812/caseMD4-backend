package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.FeeStatus;
import com.example.casestudymd4.service.FeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fee-status")
public class FeeStatusController {

    @Autowired
    private FeeStatusService feeStatusService;

    @GetMapping("/student/{id}")
    public ResponseEntity<List<FeeStatus>> getFeeStatus(@PathVariable Long id) {
        List<FeeStatus> feeStatuses = feeStatusService.getFeeStatusByStudentId(id);
        return ResponseEntity.ok(feeStatuses);
    }
}
