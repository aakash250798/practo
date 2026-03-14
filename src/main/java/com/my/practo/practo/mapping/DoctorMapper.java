package com.my.practo.practo.mapping;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorDTO mapToDTO(Doctor doctor) {

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        doctorDTO.setHospital(doctor.getHospital());
        doctorDTO.setFees(doctor.getFees());
        doctorDTO.setExperience(doctor.getExperience());
        doctorDTO.setTimeSlots(doctor.getTimeSlot().getAvailableTimeSlots());
        return doctorDTO;
    }
}
