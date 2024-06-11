package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Classer;
import com.example.casestudymd4.model.DTO.DailyLogRequest;
import com.example.casestudymd4.model.DailyLog;
import com.example.casestudymd4.model.Student;
import com.example.casestudymd4.model.StudentStatus;
import com.example.casestudymd4.repository.ClasserRepository;
import com.example.casestudymd4.repository.DailyLogRepository;
import com.example.casestudymd4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private ClasserRepository classerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DailyLogRepository dailyLogRepository;

    public List<Classer> getClassesByTeacherId(Long teacherId) {
        return classerRepository.findByTeacherId(teacherId);
    }

    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClasserId(classId);
    }

    public List<Student> getStudentsByClassIdAndStatus(Long classId, StudentStatus status) {
        return studentRepository.findByClasserIdAndStatus(classId, status);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public DailyLog createDailyLog(Long classId, DailyLogRequest dailyLogRequest) {
        DailyLog dailyLog = new DailyLog();
        dailyLog.setClassId(classerRepository.findById(classId).orElse(null));
        dailyLog.setLogDate(new Date());
        dailyLog.setContent(dailyLogRequest.getContent());
        return dailyLogRepository.save(dailyLog);
    }

    public DailyLog createStudentDailyLog(Long studentId, DailyLogRequest dailyLogRequest) {
        DailyLog dailyLog = new DailyLog();
        dailyLog.setStudent(studentRepository.findById(studentId).orElse(null));
        dailyLog.setLogDate(new Date());
        dailyLog.setContent(dailyLogRequest.getContent());
        return dailyLogRepository.save(dailyLog);
    }


}
