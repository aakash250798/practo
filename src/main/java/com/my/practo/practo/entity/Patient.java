package com.my.practo.practo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    private String id;
    private String name;
    private String email;
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
