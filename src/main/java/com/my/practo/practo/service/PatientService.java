package com.my.practo.practo.service;

import com.my.practo.practo.entity.Patient;
import com.my.practo.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void bulkSavePatients(List<Patient> patientList){
        for(Patient p : patientList){
            patientRepository.save(p);
        }

    }
}
