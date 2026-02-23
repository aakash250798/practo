package com.my.practo.practo.service;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.repository.DoctorRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    // field injection to be removed
    // add interface instead

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Set<DoctorDTO> findAllDoctorsBySpecialization(String specialization) {
        List<Doctor> doctors = doctorRepository.findAll();
        Set<Doctor> specializedDoctors = new HashSet<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().name().equals(specialization)) specializedDoctors.add(doctor);
        }
        return new DoctorDTO().getDTOFromDoctor(specializedDoctors);
    }

    public List<Appointment> findAppointmentByDoctor(String id) {
        //make sure appointment is correct
        Doctor doctor = doctorRepository.findById(id).get();
        return doctor.getAppointments();
    }

    public void bulkSaveDoctors(List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            doctorRepository.save(doctor);
        }
    }

    public Set<DoctorDTO> findAll(RequestDTO requestDTO) {


        Pageable pageable = PageRequest.of(requestDTO.getPage(), requestDTO.getSize(), Sort.by(requestDTO.getSort()));
        Set<Doctor> doctors = new HashSet<>();
        if (requestDTO.getQuery() == null || requestDTO.getQuery().trim().isEmpty()) {
            doctors = doctorRepository.findAll(pageable).toSet();
        } else {
            doctors = doctorRepository.searchDoctors(requestDTO.getQuery(),
                    PageRequest.of(requestDTO.getPage(), requestDTO.getSize(),
                            Sort.by(requestDTO.getSort()))).toSet();
        }
        return new DoctorDTO().getDTOFromDoctor(doctors);
    }

}
