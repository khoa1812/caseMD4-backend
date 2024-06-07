package com.example.casestudymd4.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DailyLogDTO {

    private Long teacherId;
    private Long classId;
    private Long studentId;
    private Date logDate;
    private String content;

}
