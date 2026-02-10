package com.my.practo.practo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AppointmentDTO {

    private String doctorId;
    private String patientId;
    private LocalDateTime timing;

}
