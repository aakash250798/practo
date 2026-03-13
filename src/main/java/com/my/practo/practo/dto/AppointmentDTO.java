package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Hospital;
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
    private String specialization;
    private LocalDateTime timing;
    private String hospital;
    private Integer fees;
    private Integer experience;

    public AppointmentDTO(Appointment appointment) {
        this.doctorId = appointment.getDoctor().getId();
        this.patientId = appointment.getPatient().getId();
        this.appointmentId = appointment.getId();
        this.doctorName = appointment.getDoctor().getName();
        this.patientName = appointment.getPatient().getName();
        this.timing = appointment.getTimeSlot();
        this.specialization = appointment.getDoctor().getSpecialization().name();
        this.hospital = getHospitalDetails(appointment.getDoctor().getHospital());
        this.fees = appointment.getDoctor().getFees();
        this.experience = appointment.getDoctor().getExperience();
    }

    public AppointmentDTO(String doctorId, String patientId, LocalDateTime timing) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.timing = timing;
    }

    private String getHospitalDetails(Hospital hospital) {
        return hospital.getName() + "," + hospital.getAddressLine1() + "," +
                hospital.getAddressLine2() + "," + hospital.getCity();
    }

}
