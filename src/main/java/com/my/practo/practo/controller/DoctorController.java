package com.my.practo.practo.controller;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService practoService;

    @GetMapping("/findBySpecialization")
    private List<DoctorDTO> findBySpecialization(@RequestParam String specialization) {
        return practoService.findAllDoctorsBySpecialization(specialization);
    }

    @GetMapping("/find")
    private List<DoctorDTO> findAll(@RequestBody RequestDTO requestDTO) {
        return practoService.findAll(requestDTO);
    }

    @GetMapping("/findById")
    private ResponseEntity<DoctorDTO> findById(@RequestBody String id) {
       DoctorDTO doctorDTO = practoService.findById(id);
        HttpStatus status;
       if(doctorDTO == null){
           status = HttpStatus.NOT_FOUND;
       }
       else
           status = HttpStatus.OK;

       return new ResponseEntity<>(doctorDTO,status);
    }

}
