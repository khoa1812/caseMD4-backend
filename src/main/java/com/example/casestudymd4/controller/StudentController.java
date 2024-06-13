//package com.example.casestudymd4.controller;
//
//import com.example.casestudymd4.model.DTO.StudentDTO;
//import com.example.casestudymd4.model.Grade;
//import com.example.casestudymd4.model.Student;
//import com.example.casestudymd4.model.StudentStatus;
//import com.example.casestudymd4.service.GradeService;
//import com.example.casestudymd4.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private GradeService gradeService;
//
//    @GetMapping("/user/{userId}")
//    public List<StudentDTO> getStudentsByUserId(@PathVariable Long userId) {
//        return studentService.findAllStudentsWithUser(userId);
//    }
//
//    @GetMapping("/class/{classId}")
//    public List<Student> getStudentsByClassId(@PathVariable Long classId) {
//        return studentService.getStudentsByClassId(classId);
//    }
//
//    @GetMapping("/status/{status}")
//    public List<Student> getStudentsByStatus(@PathVariable StudentStatus status) {
//        return studentService.getStudentsByStatus(status);
//    }
//
//    @GetMapping("/{studentId}")
//    public List<StudentDTO> getStudentByUser(@PathVariable Long studentId) {
//        return studentService.findAllStudentsWithUser(studentId);
//    }
//
//    @GetMapping("/st/{studentId}")
//    public ResponseEntity<Iterable<Grade>> getGradeByStudentId(@PathVariable Long student_Id) {
//        Iterable<Grade> grades = gradeService.getGradeByStudentId(student_Id);
////        if (grades.isEmpty()) {
////            return ResponseEntity.noContent().build();
////        }
//        return ResponseEntity.ok(grades);
//    }
//}

package com.example.casestudymd4.controller;

import com.example.casestudymd4.model.DTO.StudentDTO;
import com.example.casestudymd4.model.FeeStatus;
import com.example.casestudymd4.model.Grade;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.service.FeeStatusService;
import com.example.casestudymd4.service.GradeService;
import com.example.casestudymd4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private FeeStatusService feeStatusService;

    // Lấy danh sách sinh viên theo user ID
    @GetMapping("/user/{userId}")
    public List<StudentDTO> getStudentsByUserId(@PathVariable Long userId) {
        return studentService.findAllStudentsWithUser(userId);
    }

    // Lấy danh sách sinh viên theo lớp ID
    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClassId(@PathVariable Long classId) {
        return studentService.getStudentsByClassId(classId);
    }

    // Lấy danh sách sinh viên theo trạng thái
    @GetMapping("/status/{status}")
    public List<Student> getStudentsByStatus(@PathVariable StudentStatus status) {
        return studentService.getStudentsByStatus(status);
    }

    // Lấy thông tin sinh viên theo ID sinh viên
    @GetMapping("/{studentId}")
    public List<Student> getStudentByUser(@PathVariable Long studentId) {
        return studentService.getStudentByUid(studentId);
    }

    // Lấy điểm của sinh viên theo ID sinh viên
    @GetMapping("/grade/{studentId}")
    public ResponseEntity<Iterable<Grade>> getGradeByStudentId(@PathVariable Long studentId) {
        Iterable<Grade> grades = gradeService.getGradeByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }

    // Lấy trạng thái học phí của sinh viên theo ID sinh viên
    @GetMapping("/fee/{studentId}")
    public List<FeeStatus> getFeeStatusByStudentId(@PathVariable Long studentId) {
        return feeStatusService.getFeeStatusByStudentId(studentId);
    }

    // Lấy lần thanh toán tiếp theo của sinh viên theo ID sinh viên
    @GetMapping("/fee/{studentId}/next-payment")
    public List<FeeStatus> getNextPaymentByStudentId(@PathVariable Long studentId) {
        return feeStatusService.getNextPaymentByStudentId(studentId);
    }
}
