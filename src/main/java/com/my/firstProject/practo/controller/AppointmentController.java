package com.my.firstProject.practo.controller;

import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    DoctorService doctorService;


    @GetMapping("/find")
    private List<Doctor> findAllDoctors(){
        return doctorService.findAllDoctors();
    }

    @GetMapping("/findBySpecialization")
    private List<Doctor> findBySpecialization( @RequestParam String specialization){
        return doctorService.findAllDoctorsBySpecialization(specialization);
    }
}
