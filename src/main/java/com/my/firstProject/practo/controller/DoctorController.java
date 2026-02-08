package com.my.firstProject.practo.controller;

import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService practoService;

    @GetMapping("/find")
    private List<Doctor> findAllDoctors(){
        return practoService.findAllDoctors();
    }

    @GetMapping("/findBySpecialization")
    private List<Doctor> findBySpecialization( @RequestParam String specialization){
        return practoService.findAllDoctorsBySpecialization(specialization);
    }
}
