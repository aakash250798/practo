package com.my.firstProject.practo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class Appointment {
    @Id
    private String id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private LocalTime timeSlot;

}
