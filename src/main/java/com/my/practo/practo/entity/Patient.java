package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<Appointment> appointments;

    public Patient(){
    }

    public Patient(String id, String name){
        this.id = id;
        this.name = name;
    }

}
