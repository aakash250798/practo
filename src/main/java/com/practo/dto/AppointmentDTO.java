package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Hospital;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
public class AppointmentDTO {

    private String appointmentId;
    private String doctorId;
    private String doctorName;
    private String patientName;
    private String patientId;
    private String specialization;
    private LocalDateTime timing;
    private String hospital;
    private Integer fees;
    private Integer experience;



    public AppointmentDTO(String doctorId, String patientId, LocalDateTime timing) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.timing = timing;
    }



}
