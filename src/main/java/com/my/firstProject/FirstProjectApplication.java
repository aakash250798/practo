package com.my.firstProject;

import com.my.firstProject.practo.entity.Appointment;
import com.my.firstProject.practo.entity.Doctor;
import com.my.firstProject.practo.entity.Patient;
import com.my.firstProject.practo.repository.DoctorRepository;
import com.my.firstProject.practo.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FirstProjectApplication {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @PostConstruct
    public void setSomeValues() {
        List<Doctor> doctors = List.of(

                new Doctor("DOC_101", "Dr. Aarav Malhotra", "Physician", "Bangalore", 500, 6.5, "Morning"),
                new Doctor("DOC_102", "Dr. Meera Iyer", "Physician", "Chennai", 550, 7.2, "Evening"),
                new Doctor("DOC_103", "Dr. Rohit Verma", "Physician", "Delhi", 600, 8.0, "Night"),

                new Doctor("DOC_104", "Dr. Rohan Kulkarni", "Orthopedics", "Pune", 850, 10.2, "Morning"),
                new Doctor("DOC_105", "Dr. Ananya Sen", "Orthopedics", "Kolkata", 900, 11.5, "Afternoon"),
                new Doctor("DOC_106", "Dr. Kunal Shah", "Orthopedics", "Mumbai", 950, 13.0, "Evening"),

                new Doctor("DOC_107", "Dr. Priya Nair", "Pulmonologist", "Trivandrum", 750, 9.1, "Morning"),
                new Doctor("DOC_108", "Dr. Sandeep Rao", "Pulmonologist", "Hyderabad", 800, 10.0, "Afternoon"),
                new Doctor("DOC_109", "Dr. Kavita Joshi", "Pulmonologist", "Nagpur", 820, 10.8, "Night"),

                new Doctor("DOC_110", "Dr. Aarav Mehta", "Cardiologist", "Bangalore", 1000, 14.5, "Morning"),
                new Doctor("DOC_111", "Dr. Nikhil Bansal", "Cardiologist", "Gurgaon", 1100, 15.2, "Evening"),
                new Doctor("DOC_112", "Dr. Sneha Kulkarni", "Cardiologist", "Indore", 1050, 13.8, "Night"),

                new Doctor("DOC_113", "Dr. Meera Kapoor", "Dermatologist", "Jaipur", 700, 8.4, "Morning"),
                new Doctor("DOC_114", "Dr. Ritu Saxena", "Dermatologist", "Noida", 720, 9.0, "Afternoon"),
                new Doctor("DOC_115", "Dr. Ankit Jain", "Dermatologist", "Udaipur", 680, 7.5, "Evening"),

                new Doctor("DOC_116", "Dr. Rahul Menon", "Physiotherapist", "Kochi", 600, 6.8, "Morning"),
                new Doctor("DOC_117", "Dr. Pooja Mishra", "Physiotherapist", "Bhopal", 620, 7.1, "Afternoon"),

                new Doctor("DOC_118", "Dr. Karan Patel", "Dentist", "Ahmedabad", 500, 5.9, "Morning"),
                new Doctor("DOC_119", "Dr. Neha Gupta", "Dentist", "Faridabad", 550, 6.3, "Evening"),
                new Doctor("DOC_120", "Dr. Amit Joshi", "Dentist", "Surat", 580, 7.0, "Night")
        );
        doctorRepository.saveAll(doctors);

        List<Patient> patients = Arrays.asList(new Patient("PAT101","Akash"),
                new Patient("PAT102","Dhoni"));
        patientRepository.saveAll(patients);

    }

}
