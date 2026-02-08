package com.my.firstProject.practo.dto;

import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.entity.Patient;


public class BookingDTO {

    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;

    public BookingDTO(Doctor doctor, Patient patient, Appointment appointment) {
        this.appointment = appointment;
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment done for Patient " + appointment.getPatientsId() + " with Doctor " + appointment.getDoctorsId() + " at time " + appointment.getTimeSlot();
    }
}
