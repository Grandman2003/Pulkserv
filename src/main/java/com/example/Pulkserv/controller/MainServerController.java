package com.example.Pulkserv.controller;

import com.example.Pulkserv.domain.Classroom;
import com.example.Pulkserv.domain.Lesson;
import com.example.Pulkserv.domain.Schedule;
import com.example.Pulkserv.domain.Teacher;
import com.example.Pulkserv.repo.ClassroomRepo;
import com.example.Pulkserv.repo.SheduleRepo;
import com.example.Pulkserv.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shedules")
public class MainServerController {
    @Autowired
    private ClassroomRepo classroomRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private SheduleRepo sheduleRepo;

    @GetMapping("{{date}}")
    public Schedule getdateShedule(@PathVariable String date){
        return sheduleRepo.findSheduleByDate(date);
    }

    @PostMapping("/teachers")
    public Teacher addNewTeacher(@RequestBody Teacher teacher){
        teacherRepo.save(teacher);
        return teacher;
    }

    @PostMapping("/classroom")
    public Classroom addNewClassroom(@RequestBody Classroom classroom){
        classroomRepo.save(classroom);
        return classroom;
    }

    @PostMapping("/shedule")
    public Schedule addNewShedule(@RequestBody Schedule schedule){
        sheduleRepo.save(schedule);
        return schedule;
    }

    @PostMapping("/shedule/create")
    public Schedule createNewShedule(@RequestBody Lesson[] lessons, @RequestParam String date, @RequestParam int weekNum){
        Schedule schedule =new Schedule(weekNum,date,lessons);
        sheduleRepo.save(schedule);
        return schedule;
    }

    @PutMapping("/shedule/edit/{{date}}")
    public Schedule editShedule(@RequestBody Lesson[] lessons, @PathVariable String date){
        Schedule schedule =sheduleRepo.findSheduleByDate(date);
        schedule.setLessonList(lessons);
        sheduleRepo.flush();
        return schedule;
    }

    @GetMapping
    public List<Schedule> getSomeShedule(@RequestParam String first, @RequestParam String last){
        List<Schedule> sheduleList=new ArrayList<>();
        String[]firstday=first.split(".");
        int firsty=Integer.parseInt(firstday[0]);
        String[]secondday=last.split(".");
        int secondy=Integer.parseInt(firstday[0]);
        for(int i=firsty;i<=secondy;i++){
            int j=i;
            if(i>30){
                firstday[2]=(String.valueOf(Integer.parseInt(firstday[2])+1));
                j=j-30;
            }
            sheduleList.add(sheduleRepo.findSheduleByDate(firstday[1]+"."+firstday[2]+"."+String.valueOf(j)));
        }
        return sheduleList;
    }


}
