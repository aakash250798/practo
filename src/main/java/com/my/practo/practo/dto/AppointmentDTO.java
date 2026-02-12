package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AppointmentDTO {


    private String appointmentId;
    private String doctorId;
    private String doctorName;
    private String patientName;
    private String patientId;
    private LocalDateTime timing;
    private String finalResponse;

    public AppointmentDTO (Appointment appointment, String finalResponse){
        this.appointmentId = appointment.getId();
        this.doctorName = appointment.getDoctor().getName();
        this.patientName = appointment.getPatient().getName();
        this.timing = appointment.getTimeSlot();
        this.finalResponse = finalResponse;
    }

    public AppointmentDTO(String doctorId, String patientId, LocalDateTime timing){
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.timing = timing;
    }

}
