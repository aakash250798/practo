package com.my.firstProject.practo.controller;

import com.my.firstProject.practo.dto.AppointmentDTO;
import com.my.firstProject.practo.dto.BookingDTO;
import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.service.AppointmentService;
import com.my.firstProject.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/find")
    private Appointment getAppointment(String id){
        return appointmentService.findAppointmentById(id);
    }

    @PostMapping("/save")
    private BookingDTO saveAppointment(@RequestBody AppointmentDTO appointment){
        BookingDTO bookingDTO = appointmentService.saveAppointment(appointment);
        return bookingDTO;
    }
}
