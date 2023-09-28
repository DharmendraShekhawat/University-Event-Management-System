package com.dharmendra.University.Management.System.repository;

import com.dharmendra.University.Management.System.entity.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Eventrepo extends JpaRepository<EventModel, Integer> {

@Modifying
@Query(value = "delete from event_model where event_id =:id", nativeQuery = true)
    void deleteEventById(Integer id);

@Query(value = "select * from event_model where start_time =:time", nativeQuery = true)
    List<EventModel> getEvent(LocalDateTime time);
}
