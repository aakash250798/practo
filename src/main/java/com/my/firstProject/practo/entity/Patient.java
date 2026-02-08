package com.my.firstProject.practo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    private String id;
    private String name;
    @OneToMany
    private List<Appointment> appointment;



}
