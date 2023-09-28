package com.dharmendra.University.Management.System.service;

import com.dharmendra.University.Management.System.entity.Department;
import com.dharmendra.University.Management.System.entity.EventModel;
import com.dharmendra.University.Management.System.entity.StudentModel;
import com.dharmendra.University.Management.System.repository.Eventrepo;
import com.dharmendra.University.Management.System.repository.Irepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    Irepo StudentRepo;
    @Autowired
    Eventrepo eventRepo;

    public String addStudents(List<StudentModel> students) {
        StudentRepo.saveAll(students);
        return students.size() + " students added";
    }
@Transactional
    public String updateStudentDepartment(Integer studentId, Department department) {
        StudentRepo.updateStudentDepartment(studentId, department.name());
        return "updated";
    }
    @Transactional
    public String deleteStudentById(Integer id) {
          StudentRepo.deleteStudentById(id);
          return id +  " delete ";
    }

    public List<StudentModel> getAllStudents() {
        return StudentRepo.getAllStudents();
    }

    public List<StudentModel> getStudentById(Integer studentId) {
      return StudentRepo.getStudentById(studentId);
    }

    public String addEvents(List<EventModel> events) {
        eventRepo.saveAll(events);
        return events.size() + " added";
    }
    @Transactional
    public String updateEvent(EventModel event) {
    Optional<EventModel> optionalEventModel =  eventRepo.findById(event.getEventId());
    EventModel ev = optionalEventModel.orElse(new EventModel());

    if(ev.getEventId().equals(event.getEventId())){
        eventRepo.save(event);
        return " updated";
    }
    return " invalid id";
    }
    @Transactional
    public String deleteEventById(Integer id) {
        eventRepo.deleteEventById(id);
        return id + " delete";
    }

    public List<EventModel> getEvents(LocalDateTime time) {
        return eventRepo.getEvent(time);
    }
}
