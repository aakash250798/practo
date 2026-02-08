package com.my.practo.practo.service;

import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.repository.AppointmentRepository;
import com.my.practo.practo.repository.DoctorRepository;
import com.my.practo.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    // field injection to be removed
    // add interface instead

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> findAllDoctorsBySpecialization(String specialization) {
        List<Doctor> doctors = doctorRepository.findAll();
        List<Doctor> specializedDoctors = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getSpecialization().equals(specialization))
                specializedDoctors.add(doctor);
        }
        return specializedDoctors;
    }

    public List<Appointment> findAppointmentByDoctor(String id){
        //make sure appointment is correct
        Doctor doctor = doctorRepository.findById(id).get();
       return doctor.getAppointments();
    }
}
