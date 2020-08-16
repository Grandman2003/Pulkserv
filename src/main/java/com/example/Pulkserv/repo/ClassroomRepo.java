package com.example.Pulkserv.repo;

import com.example.Pulkserv.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo extends JpaRepository<Classroom, Long> {
    Classroom findClassrommByNumber(int number);
}
