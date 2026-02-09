package com.my.practo.practo.service;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.dto.BookingDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Patient;
import com.my.practo.practo.repository.AppointmentRepository;
import com.my.practo.practo.repository.DoctorRepository;
import com.my.practo.practo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentDTO.getDoctorId());
        Optional<Patient> optionalPatient = patientRepository.findById(appointmentDTO.getPatientId());
        if (optionalDoctor.isEmpty() || optionalPatient.isEmpty())
            return new BookingDTO("Wrong Doctor or Patient Id", null,
                    null, null, null, null, appointmentDTO.getTimeSlot(), null);

        // booked timeSlot means timeSlot
        Doctor doctor = optionalDoctor.get();
        Patient patient = optionalPatient.get();
        List<Integer> timeSlots = doctor.getTimeSlots();

        if (!timeSlots.contains(appointmentDTO.getTimeSlot())) {
            // book appointment
            Appointment appointment = new Appointment();
            appointment.setId(String.valueOf(UUID.randomUUID()));
            timeSlots.add(appointmentDTO.getTimeSlot());
            doctor.setTimeSlots(timeSlots);
            doctorRepository.save(doctor);
            appointment.setTimeSlot(appointmentDTO.getTimeSlot());
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointmentRepository.save(appointment);
            return new BookingDTO("Appointment Booked Successfully", appointment.getId(), doctor.getName(),
                    doctor.getSpecialization(), patient.getName(), doctor.getLocation(), appointmentDTO.getTimeSlot(), doctor.getFees());
        }
        else
            return new BookingDTO("Booking Failed due to unavailability of timeSlot", null, doctor.getName(), doctor.getSpecialization(), patient.getName(), doctor.getLocation(), appointmentDTO.getTimeSlot(), null);
    }
}
