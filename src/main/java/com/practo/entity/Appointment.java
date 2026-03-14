package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id", "timeSlot"})})
public class Appointment {
    @Id
    @Setter
    private String id;
    @Setter
    private LocalDateTime timeSlot;
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
}
