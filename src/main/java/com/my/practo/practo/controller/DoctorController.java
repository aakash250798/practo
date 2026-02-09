package com.my.practo.practo.controller;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    private Set<DoctorDTO> findBySpecialization(@RequestParam String specialization){
        return practoService.findAllDoctorsBySpecialization(specialization);
    }
}
