package com.example.Pulkserv.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;
    private Lesson[] lessonList;

    public Schedule(int weekNum, String date, Lesson[] lessonList) {
        this.date = date;
        this.lessonList = lessonList;
    }

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Lesson[] getLessonList() {
        return lessonList;
    }

    public void setLessonList(Lesson[] lessonList) {
        this.lessonList = lessonList;
    }
}
