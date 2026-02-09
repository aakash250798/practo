package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    public enum Shift{
        Morning, Afternoon, Evening, Night
    };
    private Shift shift;

    @ElementCollection
    @Setter
    private List<Integer> timeSlots = new ArrayList<>(); //LocalTime time = LocalTime.of(10, 30, 15);
    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String id, String name, Specialization specialization, String location, Integer fees, Integer experience, Shift shift) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.fees = fees;
        this.experience = experience;
        this.shift = shift;
    }
}


