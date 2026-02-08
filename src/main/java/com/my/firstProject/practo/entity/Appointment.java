package com.my.firstProject.practo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Appointment {
    @Id
    private String id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private Integer timeSlot;

    public void setTimeSlot(Integer timeSlot){
        List<Integer> timeSlots = doctor.getTimeSlots();
        if(timeSlots.contains(timeSlot)){
            timeSlots.remove(timeSlot);
        }
        else
            this.timeSlot = null;
    }

}
