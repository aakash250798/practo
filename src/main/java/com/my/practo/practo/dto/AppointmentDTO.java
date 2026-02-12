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

    public AppointmentDTO (Appointment appointment){
        this.doctorId = appointment.getDoctor().getId();
        this.patientId = appointment.getPatient().getId();
        this.appointmentId = appointment.getId();
        this.doctorName = appointment.getDoctor().getName();
        this.patientName = appointment.getPatient().getName();
        this.timing = appointment.getTimeSlot();

    }

    public AppointmentDTO(String doctorId, String patientId, LocalDateTime timing){
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.timing = timing;
    }

}
