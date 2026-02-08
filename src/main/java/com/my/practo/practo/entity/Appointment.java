package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id", "timeSlot"})})
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
