package com.example.Pulkserv.repo;

import com.example.Pulkserv.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByLastname(String lastname);
}
