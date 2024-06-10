package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
}
