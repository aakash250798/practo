package com.my.practo.practo.service;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.akash.security.SecurityService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

        List<Doctor> doctorList = doctorRepository.findAll();
        Set<DoctorDTO> doctors = new DoctorDTO().getDTOFromDoctor(new HashSet<>(doctorList));
        return findByQuery(doctors, requestDTO);
    }

    private Set<DoctorDTO> findByQuery(Set<DoctorDTO> doctor, RequestDTO requestDTO) {

        String[] fields = requestDTO.getSort().split(",");

        Sort sort = Sort.by(
                Sort.Direction.fromString(requestDTO.getDirection()),
                fields
        );
       Set<Doctor> doctors = new HashSet<>(doctorRepository.search(requestDTO, sort));
       return new DoctorDTO().getDTOFromDoctor(doctors);
    }
}
