package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id", "timeSlot"})})
public class Appointment {
    @Id
    @Setter
    private String id;
    @Setter
    private Integer timeSlot;
    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    @Setter
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    @Setter
    private Patient patient;

    public Appointment() {
    }

//    public Appointment(String id, Integer timeSlot, Doctor doctor, Patient patient) {
//        this.id
//    }
}
