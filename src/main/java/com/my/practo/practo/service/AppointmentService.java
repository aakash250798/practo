package com.my.practo.practo.service;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.dto.BookingDTO;
import com.my.practo.practo.dto.TimeSlot;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Patient;
import com.my.practo.practo.repository.AppointmentRepository;
import com.my.practo.practo.repository.DoctorRepository;
import com.my.practo.practo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
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

    @Autowired
    NotificationService notificationService;

    public ResponseEntity<AppointmentDTO> findAppointmentById(String id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<AppointmentDTO>(new AppointmentDTO(optional.get()),HttpStatus.OK);
    }

    // response format shud be better
    @Transactional
    public BookingDTO saveAppointment(AppointmentDTO appointmentDTO) throws IOException {
        //make sure appointment is correct
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentDTO.getDoctorId());
        Optional<Patient> optionalPatient = patientRepository.findById(appointmentDTO.getPatientId());
        if (optionalDoctor.isEmpty() || optionalPatient.isEmpty())
            return new BookingDTO("Wrong Doctor or Patient Id", null,
                    null, null, null, null, appointmentDTO.getTiming(), null);

        // booked timeSlot means timeSlot
        Doctor doctor = optionalDoctor.get();
        Patient patient = optionalPatient.get();
        LocalDateTime timing = appointmentDTO.getTiming();
        if (doctor.getTimeSlot().bookTimeSlot(timing)) {
            TimeSlot timeSlot = doctor.getTimeSlot();
            timeSlot.setBookedTimeSlots(timing);
            doctor.setTimeSlot(timeSlot);
            Appointment appointment = new Appointment();
            appointment.setId(String.valueOf(UUID.randomUUID()));
            doctorRepository.save(doctor);
            appointment.setTimeSlot(timing);
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointmentRepository.save(appointment);
            notificationService.sendEmail();// notification service

            return new BookingDTO("Appointment Booked Successfully", appointment.getId(), doctor.getName(),
                    doctor.getSpecialization(), patient.getName(), doctor.getHospital(), timing, doctor.getFees());

        } else
            return new BookingDTO("Booking Failed due to unavailability of timeSlot", null, doctor.getName(), doctor.getSpecialization(), patient.getName(), doctor.getHospital(), appointmentDTO.getTiming(), null);
    }

}
