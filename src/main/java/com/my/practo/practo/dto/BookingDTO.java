package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BookingDTO {
    private String message;
    private String appointmentId;
    private String doctorName;
    private Doctor.Specialization specialization;
    private String patientName;
    private String location;
    private Integer timeSlot;
    private Integer fees;


    public BookingDTO(String message,
                      String appointmentId,
                      String doctorName,
                      Doctor.Specialization specialization,
                      String patientName,
                      String location,
                      Integer timeSlot,
                      Integer fees) {

        this.message = message;
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.patientName = patientName;
        this.location = location;
        this.timeSlot = timeSlot;
        this.fees = fees;
    }

}
