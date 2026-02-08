package com.my.firstProject.practo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppointmentDTO {

    private String doctorId;
    private String patientId;
    private Integer timeSlot;

}
