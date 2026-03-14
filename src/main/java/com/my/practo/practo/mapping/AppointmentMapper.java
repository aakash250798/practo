package com.my.practo.practo.mapping;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Hospital;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO mapToDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDoctorId(appointment.getDoctor().getId());
        appointmentDTO.setPatientId(appointment.getPatient().getId());
        appointmentDTO.setAppointmentId(appointment.getId());
        appointmentDTO.setDoctorName(appointment.getDoctor().getName());
        appointmentDTO.setPatientName(appointment.getPatient().getName());
        appointmentDTO.setTiming(appointment.getTimeSlot());
        appointmentDTO.setSpecialization(appointment.getDoctor().getSpecialization().name());
        appointmentDTO.setHospital(getHospitalDetails(appointment.getDoctor().getHospital()));
        appointmentDTO.setFees(appointment.getDoctor().getFees());
        appointmentDTO.setExperience(appointment.getDoctor().getExperience());
        return appointmentDTO;
    }

    private String getHospitalDetails(Hospital hospital) {
        return hospital.getName() + "," + hospital.getAddressLine1() + "," +
                hospital.getAddressLine2() + "," + hospital.getCity();
    }
}
