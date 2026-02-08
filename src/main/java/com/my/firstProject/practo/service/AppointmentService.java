package com.my.firstProject.practo.service;

import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public Appointment findAppointmentById(String id){
        //make sure appointment is correct
        return appointmentRepository.findById(id).get();
    }

    public Appointment saveAppointment(Appointment appointment){
        //make sure appointment is correct
        return appointmentRepository.save(appointment);
    }
}
