package com.my.firstProject.practo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Appointment {
    @Id
    private String id;
    private Integer timeSlot;
    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    public Appointment() {
    }

//    public Appointment(String id, Integer timeSlot, Doctor doctor, Patient patient) {
//        this.id
//    }
}
