package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Hospital;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private String message;
    private String appointmentId;
    private String doctorName;
    private Doctor.Specialization specialization;
    private String patientName;
    private Hospital hospital;
    private LocalDateTime timing;
    private Integer fees;

    public BookingDTO(String message, String appointmentId, String doctorName, Doctor.Specialization specialization, String patientName, Hospital hospital, LocalDateTime timing, Integer fees) {
        this.message = message;
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.patientName = patientName;
        this.hospital = hospital;
        this.timing = timing;
        this.fees = fees;
    }

    @Override
    public String toString(){
        return "BookingDTO{" +
                "message='" + message + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", specialization=" + specialization +
                ", patientName='" + patientName + '\'' +
                ", hospital=" + hospital +
                ", timing=" + timing +
                ", fees=" + fees +
                '}';
    }
}
