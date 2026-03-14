package com.my.practo.practo.controller;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.dto.BookingDTO;
import com.my.practo.practo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/findById/{id}")
    private ResponseEntity<AppointmentDTO> getAppointment(@PathVariable String id, @RequestHeader(required = false) String authorization) {
        // check authorized or not
        return ResponseEntity.ok(appointmentService.findAppointmentById(id));
    }

    @PostMapping("/save")
    private ResponseEntity<BookingDTO> saveAppointment(@RequestBody AppointmentDTO appointment) {
        BookingDTO bookingDTO = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(bookingDTO);

    }
}
