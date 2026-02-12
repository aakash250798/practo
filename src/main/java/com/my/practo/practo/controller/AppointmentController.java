package com.my.practo.practo.controller;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.dto.BookingDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.service.AppointmentService;
import com.my.practo.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/findById/{id}")
    private ResponseEntity<AppointmentDTO> getAppointment(@PathVariable String id){
        return appointmentService.findAppointmentById(id);
    }

    @PostMapping("/save")
    private BookingDTO saveAppointment(@RequestBody AppointmentDTO appointment){
        BookingDTO bookingDTO = appointmentService.saveAppointment(appointment);
        return bookingDTO;
    }
}
