package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String id;
    private String name;
    private Doctor.Specialization specialization;
    private Hospital hospital;
    private Integer fees;
    private Integer experience;
    private List<LocalDateTime> timeSlots;

    public static List<DoctorDTO> getDTOFromDoctor(List<Doctor> doctors) {
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.id = doctor.getId();
            doctorDTO.name = doctor.getName();
            doctorDTO.specialization = doctor.getSpecialization();
            doctorDTO.hospital = doctor.getHospital();
            doctorDTO.fees = doctor.getFees();
            doctorDTO.experience = doctor.getExperience();
            doctorDTO.timeSlots = doctor.getTimeSlot().getAvailableTimeSlots();
            doctorDTOS.add(doctorDTO);
        }
        return doctorDTOS;
    }
}
