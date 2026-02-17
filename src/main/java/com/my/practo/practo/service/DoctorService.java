package com.my.practo.practo.service;

import com.my.practo.practo.dto.DoctorDTO;
import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.entity.Appointment;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.repository.DoctorRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
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

        List<Doctor> doctorList = doctorRepository.findAll();
       List<DoctorDTO> doctors = new ArrayList<>(new DoctorDTO().getDTOFromDoctor(new HashSet<>(doctorList)));

        CharSequence query = requestDTO.getQuery();
        doctors =  doctors.stream()
                .filter(e -> (e.getName().contains(query)
                        || e.getSpecialization().name().contains(query)
                        || e.getHospital().getName().contains(query)))
                .collect(Collectors.toList());

        Map<String, Comparator<DoctorDTO>> sortMap = Map.of(
                "id", Comparator.comparing(DoctorDTO::getId),
                "name", Comparator.comparing(DoctorDTO::getName),
                "fees", Comparator.comparing(DoctorDTO::getFees),
                "experience", Comparator.comparing(DoctorDTO::getExperience)
        );

        Comparator<DoctorDTO> comparator = sortMap.get(requestDTO.getSort());
        if (comparator != null) {
            doctors.sort(requestDTO.getDirection().equals("DESC") ? comparator.reversed() : comparator);
        }
        return new HashSet<>(doctors);

    }

}
