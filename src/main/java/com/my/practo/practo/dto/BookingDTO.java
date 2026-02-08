package com.my.practo.practo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDTO {
    private String message;
    private String appointmentId;
    private String doctorName;
    private String specialization;
    private String patientName;
    private String location;
    private Integer timeSlot;
    private Integer fees;

}
