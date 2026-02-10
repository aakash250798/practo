package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.my.practo.practo.dto.TimeSlot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
public class Doctor {

    @Id
    private String id;
    private String name;
    private Specialization specialization;

    public enum Specialization {
        Cardiologist, Physician, Orthopedics, Dermatologist, Dentist
    };
    private String location;
    private Integer fees;
    private Integer experience;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Hospital hospital;

    public enum Shift{
        Morning, Afternoon, Evening, Night
    };


    @Setter
    private TimeSlot timeSlot; //LocalTime time = LocalTime.of(10, 30, 15);
    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String id, String name, Specialization specialization, String location, Integer fees, Integer experience) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.fees = fees;
        this.experience = experience;

        this.timeSlot = new TimeSlot();
    }
}


