package com.dharmendra.University.Management.System.controller;

import com.dharmendra.University.Management.System.entity.Department;
import com.dharmendra.University.Management.System.entity.EventModel;
import com.dharmendra.University.Management.System.entity.StudentModel;
import com.dharmendra.University.Management.System.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
public class UniversityController {
    @Autowired
    UniversityService universityService;

    // add list of students
    @PostMapping("students")
    public String addStudents(@Valid @RequestBody List<StudentModel> students){

        return universityService.addStudents(students);
    }
// update student department
    @PutMapping("student/department")
    public String updateStudentDepartment(@Valid @RequestParam Integer studentId, @Valid @RequestParam Department department){
        return universityService.updateStudentDepartment(studentId,department);
    }
    // delete student by student Id
    @DeleteMapping("student")
    public String deleteStudentById(@Valid @RequestParam Integer id){
        return universityService.deleteStudentById(id);
    }
    // get All students
     @GetMapping("allStudents")
    public List<StudentModel> getAllStudents(){
        return  universityService.getAllStudents();
    }

    // get student by id
    @GetMapping("student/studentId/{studentId}")
    public List<StudentModel> getStudentById(Integer studentId){
        return universityService.getStudentById(studentId);
    }

    // -------------------------------  Event Model   -------------------------------
//add events
    @PostMapping("events")
    public String addEvents(@Valid @RequestBody List<EventModel>  events){
        return universityService.addEvents(events);
    }

    // update events

    @PutMapping("events")
    public String updateEvents(@Valid @RequestBody EventModel event){
        return universityService.updateEvent(event);
    }
    // delete event
    @DeleteMapping("event/eventId/{id}")
    public String deleteEventById(@Valid @PathVariable Integer id){
        return universityService.deleteEventById(id);
    }
  // get all events by date
@GetMapping("allEvents")
    public List<EventModel> getEvents(@Valid @RequestParam LocalDateTime time){
        return universityService.getEvents(time);
    }

}
