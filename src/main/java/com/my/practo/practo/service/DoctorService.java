package com.my.practo.practo.service;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DoctorService {

    // field injection to be removed
    // add interface instead

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Set<DoctorDTO> findAllDoctorsBySpecialization(String specialization) {
        List<Doctor> doctors = doctorRepository.findAll();
        Set<Doctor> specializedDoctors = new HashSet<>();
        for(Doctor doctor : doctors){
            if(doctor.getSpecialization().name().equals(specialization))
                specializedDoctors.add(doctor);
        }
        return new DoctorDTO().getDTOFromDoctor(specializedDoctors);
    }

    public List<Appointment> findAppointmentByDoctor(String id){
        //make sure appointment is correct
        Doctor doctor = doctorRepository.findById(id).get();
       return doctor.getAppointments();
    }

    public void bulkSaveDoctors(List<Doctor>doctors){
        for(Doctor doctor : doctors){
            doctorRepository.save(doctor);
        }
    }
}
