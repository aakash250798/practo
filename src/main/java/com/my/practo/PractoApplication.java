package com.my.practo;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Patient;
import com.my.practo.practo.repository.DoctorRepository;
import com.my.practo.practo.repository.PatientRepository;
import com.my.practo.practo.service.AppointmentService;
import com.my.practo.practo.service.DoctorService;
import com.my.practo.practo.service.PatientService;
import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PractoApplication {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger("");

    public static void main(String[] args) {
        SpringApplication.run(PractoApplication.class, args);
    }

    @PostConstruct
    public void setSomeValues() {

        Doctor d1 = new Doctor("DOC_101", "Dr. Aarav Malhotra", Doctor.Specialization.Orthopedics, "Bangalore", 500, 6, Doctor.Shift.Morning);
        Doctor d2 = new Doctor("DOC_102", "Dr. Meera Iyer", Doctor.Specialization.Dermatologist, "Chennai", 550, 7, Doctor.Shift.Evening);
        Doctor d3 = new Doctor("DOC_103", "Dr. Rohit Verma", Doctor.Specialization.Physician, "Delhi", 600, 8, Doctor.Shift.Night);

        Doctor d4 = new Doctor("DOC_104", "Dr. Rohan Kulkarni", Doctor.Specialization.Dermatologist, "Pune", 850, 10, Doctor.Shift.Morning);
        Doctor d5 = new Doctor("DOC_105", "Dr. Ananya Sen", Doctor.Specialization.Cardiologist, "Kolkata", 900, 11, Doctor.Shift.Afternoon);
        Doctor d6 = new Doctor("DOC_106", "Dr. Kunal Shah", Doctor.Specialization.Physician, "Mumbai", 950, 13, Doctor.Shift.Evening);

        Doctor d7 = new Doctor("DOC_107", "Dr. Priya Nair", Doctor.Specialization.Cardiologist, "Trivandrum", 750, 9, Doctor.Shift.Morning);
        Doctor d8 = new Doctor("DOC_108", "Dr. Sandeep Rao", Doctor.Specialization.Orthopedics, "Hyderabad", 800, 10, Doctor.Shift.Afternoon);
        Doctor d9 = new Doctor("DOC_109", "Dr. Kavita Joshi", Doctor.Specialization.Orthopedics, "Nagpur", 820, 10, Doctor.Shift.Night);

        Doctor d10 = new Doctor("DOC_110", "Dr. Aarav Mehta", Doctor.Specialization.Cardiologist, "Bangalore", 1000, 14, Doctor.Shift.Morning);
        Doctor d11 = new Doctor("DOC_111", "Dr. Nikhil Bansal", Doctor.Specialization.Dentist, "Gurgaon", 1100, 15, Doctor.Shift.Evening);
        Doctor d12 = new Doctor("DOC_112", "Dr. Sneha Kulkarni", Doctor.Specialization.Physician, "Indore", 1050, 13, Doctor.Shift.Night);

        Doctor d13 = new Doctor("DOC_113", "Dr. Meera Kapoor", Doctor.Specialization.Physician, "Jaipur", 700, 8, Doctor.Shift.Morning);
        Doctor d14 = new Doctor("DOC_114", "Dr. Ritu Saxena", Doctor.Specialization.Dermatologist, "Noida", 720, 9, Doctor.Shift.Afternoon);
        Doctor d15 = new Doctor("DOC_115", "Dr. Ankit Jain", Doctor.Specialization.Dentist, "Udaipur", 680, 7, Doctor.Shift.Evening);

        Doctor d16 = new Doctor("DOC_116", "Dr. Rahul Menon", Doctor.Specialization.Dermatologist, "Kochi", 600, 6, Doctor.Shift.Morning);
        Doctor d17 = new Doctor("DOC_117", "Dr. Pooja Mishra", Doctor.Specialization.Orthopedics, "Bhopal", 620, 7, Doctor.Shift.Afternoon);

        Doctor d18 = new Doctor("DOC_118", "Dr. Karan Patel", Doctor.Specialization.Dentist, "Ahmedabad", 500, 5, Doctor.Shift.Morning);
        Doctor d19 = new Doctor("DOC_119", "Dr. Neha Gupta", Doctor.Specialization.Physician, "Faridabad", 550, 6, Doctor.Shift.Evening);
        Doctor d20 = new Doctor("DOC_120", "Dr. Amit Joshi", Doctor.Specialization.Cardiologist, "Surat", 580, 7, Doctor.Shift.Night);

        List<Doctor> doctors = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20);
        doctorService.bulkSaveDoctors(doctors);

        Patient p1 = new Patient("PAT_101", "Arjun");
        Patient p2 = new Patient("PAT_102", "Ananya");
        Patient p3 = new Patient("PAT_103", "Rohit");
        Patient p4 = new Patient("PAT_104", "Riya");
        Patient p5 = new Patient("PAT_105", "Siddharth");
        Patient p6 = new Patient("PAT_106", "Ishita");
        Patient p7 = new Patient("PAT_107", "Aditya");
        Patient p8 = new Patient("PAT_108", "Sneha");
        Patient p9 = new Patient("PAT_109", "Vikram");
        Patient p10 = new Patient("PAT_110", "Kavya");
        Patient p11 = new Patient("PAT_111", "Karan");
        Patient p12 = new Patient("PAT_112", "Harsh");
        Patient p13 = new Patient("PAT_113", "Ankit");
        Patient p14 = new Patient("PAT_114", "Nikhil");
        Patient p15 = new Patient("PAT_115", "Pranav");
        Patient p16 = new Patient("PAT_116", "Raghav");
        Patient p17 = new Patient("PAT_117", "Shivam");
        Patient p18 = new Patient("PAT_118", "Manish");
        Patient p19 = new Patient("PAT_119", "Varun");
        Patient p20 = new Patient("PAT_120", "Yash");
        Patient p21 = new Patient("PAT_121", "Aman");
        Patient p22 = new Patient("PAT_122", "Abhishek");
        Patient p23 = new Patient("PAT_123", "Jay");
        Patient p24 = new Patient("PAT_124", "Dev");
        Patient p25 = new Patient("PAT_125", "Ritesh");

        List<Patient> patients = Arrays.asList(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25
        );
        patientService.bulkSavePatients(patients);

        AppointmentDTO a1 = new AppointmentDTO("DOC_101", "PAT_101", 930);
        AppointmentDTO a2 = new AppointmentDTO("DOC_105", "PAT_104", 1230);
        AppointmentDTO a3 = new AppointmentDTO("DOC_108", "PAT_108", 1400);
        AppointmentDTO a4 = new AppointmentDTO("DOC_103", "PAT_110", 2030);
        AppointmentDTO a5 = new AppointmentDTO("DOC_110", "PAT_112", 1000);
        AppointmentDTO a6 = new AppointmentDTO("DOC_117", "PAT_116", 1330);
        AppointmentDTO a7 = new AppointmentDTO("DOC_120", "PAT_119", 2230);
        AppointmentDTO a8 = new AppointmentDTO("DOC_114", "PAT_105", 1430);
        AppointmentDTO a9 = new AppointmentDTO("DOC_106", "PAT_107", 1730);
        AppointmentDTO a10 = new AppointmentDTO("DOC_109", "PAT_103", 2130);

        List<AppointmentDTO> appointmentDTOList = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
        for (AppointmentDTO a : appointmentDTOList) {
            logger.debug(">> Logging - " + a.getDoctorId());
            appointmentService.saveAppointment(a);
        }

    }

}
