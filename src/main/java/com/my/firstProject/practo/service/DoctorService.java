package com.my.firstProject.practo.service;

import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.repository.AppointmentRepository;
import com.my.firstProject.practo.repository.DoctorRepository;
import com.my.firstProject.practo.repository.PatientRepository;
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
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> listOfAppointmentForDoctor = new ArrayList<>();
        for(Appointment i: appointments){
            if(i.getDoctorsId().equals(doctor.getId()))
                listOfAppointmentForDoctor.add(i);
        }
        return listOfAppointmentForDoctor;
    }
}
