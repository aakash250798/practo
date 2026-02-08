package com.my.firstProject.practo.service;

import com.my.firstProject.practo.dto.BookingDTO;
import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.entity.Patient;
import com.my.firstProject.practo.repository.AppointmentRepository;
import com.my.firstProject.practo.repository.DoctorRepository;
import com.my.firstProject.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public Appointment findAppointmentById(String id){
        //make sure appointment is correct
        return appointmentRepository.findById(id).get();
    }

    // response format shud be better
    public String saveAppointment(Appointment appointment){
        //make sure appointment is correct
        Doctor doctor = doctorRepository.findById(appointment.getDoctorsId()).get();
        Patient patient = patientRepository.findById(appointment.getPatientsId()).get();
        if(doctor!=null && patient!=null && doctor.getTimeSlots().contains(appointment.getTimeSlot())){
            // book appointment
            appointment.setId(String.valueOf(UUID.randomUUID()));
            appointmentRepository.save(appointment);
            List<Integer> timeSlots = doctor.getTimeSlots();
            timeSlots.remove(appointment.getTimeSlot());
            doctor.setTimeSlots(timeSlots);
            doctorRepository.save(doctor);
            return new BookingDTO(doctor,patient,appointment).toString();
        }
        else
            return "Booking Failed";
    }
}
