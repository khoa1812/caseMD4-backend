package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.Classer;
import com.example.casestudymd4.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Get all classes
    @GetMapping
    public ResponseEntity<List<Classer>> getAllClasses() {
        List<Classer> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // Add a class
    @PostMapping
    public ResponseEntity<Classer> addClass(@RequestBody Classer classer) {
        Classer newClass = classService.addClass(classer);
        return ResponseEntity.ok(newClass);
    }

    // Delete a class
    @DeleteMapping("/{classId}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long classId) {
        classService.deleteClass(classId);
        return ResponseEntity.noContent().build();
    }
}
