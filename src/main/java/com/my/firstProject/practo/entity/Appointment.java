package com.my.firstProject.practo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Appointment {
    @Id
    private String id;
    private String doctorsId;
    private String patientsId;
    private Integer timeSlot;

    public Appointment() {
    }

}
