package com.my.firstProject.practo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Patient {
    @Id
    private String id;
    private String name;

    public Patient(){

    }

}
