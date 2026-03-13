package com.my.practo;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.entity.Hospital;
import com.my.practo.practo.repository.HospitalRepository;
import com.my.practo.practo.service.AppointmentService;
import com.my.practo.practo.service.DoctorService;
import com.my.practo.practo.service.PatientService;
import com.my.practo.practo.staticData.PractoData;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@EnableRabbit
@SpringBootApplication
public class PractoApplication {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private HospitalRepository hospitalRepository;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger("");

    public static void main(String[] args) {
        SpringApplication.run(PractoApplication.class, args);
    }

    @PostConstruct
    public void setSomeValues() throws IOException {

        List<Hospital> hospitals = PractoData.getHospitalValues();
        for(Hospital hospital:hospitals){
            hospitalRepository.save(hospital);
        }

        doctorService.bulkSaveDoctors(PractoData.getDoctorValues(hospitals));
        patientService.bulkSavePatients(PractoData.getPatientsValues());

//        for (AppointmentDTO a : PractoData.getAppointmentValues()) {
//            appointmentService.saveAppointment(a);
//        }

    }

}
