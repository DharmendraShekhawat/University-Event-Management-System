package com.dharmendra.University.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class EventModel {

    @Id
    @NotNull
    private Integer eventId;

    private String eventName;

    private String locationOfEvent;

    private LocalDate date;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
