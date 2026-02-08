package com.my.firstProject.practo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Doctor {
    @Id
    private String id;
    private String name;
//    private enum Specialization {
//        Physician,
//        Orthopedics,
//        Pulmonologist,
//        Cardiologist,
//        Dermatologist,
//        Physiotherapist,
//        Dentist
//    };
    private String specialization;
    private String location;
    private Integer fees;
    private Double experience;
    private String shift;
    private List<Integer> timeSlots; //LocalTime time = LocalTime.of(10, 30, 15);
    @OneToMany
    @JsonIgnore
    private List<Appointment> appointment;

    public void setShift(String shift) {
       if(shift.equals("Morning")){
           this.setTimeSlots(Arrays.asList(900, 930, 1000, 1030, 1100, 1130, 1200));
       }
       else if(shift.equals("Afternoon")){
           this.setTimeSlots(Arrays.asList(1200, 1230, 1300, 1330, 1400, 1430, 1500));
       }

       else if(shift.equals("Evening")){
           this.setTimeSlots(Arrays.asList(1500, 1530, 1600, 1630, 1700, 1730,1800));
       }

       else if(shift.equals("Night")){
           this.setTimeSlots(Arrays.asList(1800, 1830,1900, 1930, 2000, 2030, 2100));
       }

       else
           this.setTimeSlots(new ArrayList<>());
    }
}
