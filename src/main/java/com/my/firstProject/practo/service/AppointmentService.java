package com.my.firstProject.practo.service;

import com.my.firstProject.practo.dto.AppointmentDTO;
import com.my.firstProject.practo.dto.BookingDTO;
import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.entity.Patient;
import com.my.firstProject.practo.repository.AppointmentRepository;
import com.my.firstProject.practo.repository.DoctorRepository;
import com.my.firstProject.practo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public Appointment findAppointmentById(String id) {
        //make sure appointment is correct
        return appointmentRepository.findById(id).get();
    }

    // response format shud be better
    @Transactional
    public BookingDTO saveAppointment(AppointmentDTO appointmentDTO) {
        //make sure appointment is correct
        Optional<Doctor> doctor = doctorRepository.findById(appointmentDTO.getDoctorId());
        Optional<Patient> patient = patientRepository.findById(appointmentDTO.getPatientId());
        if (doctor.isEmpty() || patient.isEmpty())
            return new BookingDTO("Wrong Doctor or Patient Id", null,
                    null, null, null, null, appointmentDTO.getTimeSlot(),null);

        List<Integer> timeSlots = doctor.get().getTimeSlots();

        if (timeSlots.contains(appointmentDTO.getTimeSlot())) {
            // book appointment
            Appointment appointment = new Appointment();
            appointment.setId(String.valueOf(UUID.randomUUID()));
            timeSlots.remove(appointmentDTO.getTimeSlot());
            doctor.get().setTimeSlots(timeSlots);
            doctorRepository.save(doctor.get());
            appointment.setTimeSlot(appointmentDTO.getTimeSlot());
            appointment.setDoctor(doctor.get());
            appointment.setPatient(patient.get());
            appointmentRepository.save(appointment);
            return new BookingDTO( "Appointment Booked Successfully",appointment.getId(),doctor.get().getName(),
                    doctor.get().getSpecialization(),patient.get().getName(),doctor.get().getLocation(),appointmentDTO.getTimeSlot(),doctor.get().getFees());
        } else
            return new BookingDTO("Booking Failed due to unavailability of timeSlot", null, doctor.get().getName(), doctor.get().getSpecialization(), patient.get().getName(),doctor.get().getLocation(), appointmentDTO.getTimeSlot(),null);
    }
}
