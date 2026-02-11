package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String id;
    private String name;
    private Doctor.Specialization specialization;
    private String location;
    private Integer fees;
    private Integer experience;
    private List<LocalDateTime> timeSlots;

    public Set<DoctorDTO> getDTOFromDoctor(Set<Doctor> doctors) {
        Set<DoctorDTO> doctorDTOS = new HashSet<>();
        for (Doctor doctor : doctors) {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.id = doctor.getId();
            doctorDTO.name = doctor.getName();
            doctorDTO.specialization = doctor.getSpecialization();
            doctorDTO.location = doctor.getLocation();
            doctorDTO.fees = doctor.getFees();
            doctorDTO.experience = doctor.getExperience();
            doctorDTO.timeSlots = doctor.getTimeSlot().getAvailableTimeSlots();
            doctorDTOS.add(doctorDTO);
        }
        return doctorDTOS;

    }

//    private List<Integer> getTimeSlotsFromShift(Doctor doctor) {
//        String shift = doctor.getShift().name();
//        List<Integer> timeSlots = new ArrayList<>();
//        if (shift.equals("Morning")) {
//            timeSlots.addAll(Arrays.asList(900,930,1000,1030,1100,1130,1200));
//        }
//
//        if (shift.equals("Afternoon")) {
//            timeSlots.addAll(Arrays.asList(1200,1230,1300,1330,1400,1430,1500));
//        }
//
//        if (shift.equals("Evening")) {
//            timeSlots.addAll(Arrays.asList(1500,1530,1600,1630,1700,1730,1800));
//        }
//
//        if (shift.equals("Night")) {
//            timeSlots.addAll(Arrays.asList(1800,1830,1900,1930,2000,2030,2100));
//        }
//        //timeSlots.removeAll(doctor.getTimeSlots());
//        return timeSlots;
//
//    }
}
