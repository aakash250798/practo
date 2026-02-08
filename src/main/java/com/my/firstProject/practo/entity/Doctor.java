package com.my.firstProject.practo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Doctor {
    @Id
    private String id;
    private String name;
//    private enum Specialization {
//        Physician,
//        Orthopedics,
//        Pulmonologist,
//        Cardiologist,
//        Dermatologist,
//        Physiotherapist,
//        Dentist
//    };
    private String specialization;
    private String location;
    private Integer fees;
    private Double experience;
    private List<LocalTime> timeSlots; //LocalTime time = LocalTime.of(10, 30, 15);
    @OneToMany
    private List<Appointment> appointment;

}
