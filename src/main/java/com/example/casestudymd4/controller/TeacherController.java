package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.Classer;
import com.example.casestudymd4.model.DTO.DailyLogRequest;
import com.example.casestudymd4.model.DailyLog;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    // 1. Xem danh sách lớp học
    @GetMapping("/{teacherId}/classes")
    public ResponseEntity<List<Classer>> getClasses(@RequestBody @PathVariable Long teacherId) {
        List<Classer> classes = teacherService.getClassesByTeacherId(teacherId);
        return ResponseEntity.ok(classes);
    }

    // 2. Xem danh sách học viên trong lớp
    @GetMapping("/classes/{classId}/students")
    public ResponseEntity<List<Student>> getStudents(@PathVariable Long classId) {
        List<Student> students = teacherService.getStudentsByClassId(classId);
        return ResponseEntity.ok(students);
    }

    // 3. Lọc học viên theo trạng thái
    @GetMapping("/classes/{classId}/students/status")
    public ResponseEntity<List<Student>> getStudentsByStatus(@PathVariable Long classId, @RequestParam StudentStatus status) {
        List<Student> students = teacherService.getStudentsByClassIdAndStatus(classId, status);
        return ResponseEntity.ok(students);
    }

    // 4. Xem chi tiết học viên
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable Long studentId) {
        Student student = teacherService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    // 5. Viết nhật ký hàng ngày cho lớp
    @PostMapping("/classes/{classId}/dailylog")
    public ResponseEntity<DailyLog> createDailyLog(@PathVariable Long classId, @RequestBody DailyLogRequest dailyLogRequest) {
        DailyLog dailyLog = teacherService.createDailyLog(classId, dailyLogRequest);
        return ResponseEntity.ok(dailyLog);
    }

    // 6. Viết nhật ký hàng ngày cho học viên
    @PostMapping("/students/{studentId}/dailylog")
    public ResponseEntity<DailyLog> createStudentDailyLog(@PathVariable Long studentId, @RequestBody DailyLogRequest dailyLogRequest) {
        DailyLog dailyLog = teacherService.createStudentDailyLog(studentId, dailyLogRequest);
        return ResponseEntity.ok(dailyLog);
    }
}
