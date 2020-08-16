package com.example.Pulkserv.repo;

import com.example.Pulkserv.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheduleRepo extends JpaRepository<Schedule, Long> {
    Schedule findSheduleByDate(String date);
}
