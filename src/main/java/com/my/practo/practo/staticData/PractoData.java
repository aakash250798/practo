package com.my.practo.practo.staticData;

import com.my.practo.practo.dto.AppointmentDTO;
import com.my.practo.practo.dto.TimeSlot;
import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Hospital;
import com.my.practo.practo.entity.Patient;
import java.util.Arrays;
import java.util.List;

public class PractoData {

    public static List<Hospital> getHospitalValues() {
        Hospital h1 = new Hospital("H001", "Apollo Hospital", "Jayanagar", "https://www.apollohospitals.com", "080-12345678", "No. 154, 9th Block", "Near Jayanagar Metro", "Bangalore", "Karnataka", "560011", "India");
        Hospital h2 = new Hospital("H002", "Fortis Hospital", "Bannerghatta Road", "https://www.fortishealthcare.com", "080-22334455", "154/9, Bannerghatta Rd", "Opp IIM Bangalore", "Bangalore", "Karnataka", "560076", "India");
        Hospital h3 = new Hospital("H003", "Manipal Hospital", "Whitefield", "https://www.manipalhospitals.com", "080-33445566", "98, HAL Old Airport Rd", "Near ITPL", "Bangalore", "Karnataka", "560066", "India");
        Hospital h4 = new Hospital("H004", "Columbia Asia Hospital", "Hebbal", "https://www.columbiaasia.com", "080-44556677", "No. 43, Kirloskar Business Park", "Bellary Road", "Bangalore", "Karnataka", "560024", "India");
        Hospital h5 = new Hospital("H005", "Narayana Health", "Electronic City", "https://www.narayanahealth.org", "080-55667788", "258/A, Bommasandra", "Industrial Area", "Bangalore", "Karnataka", "560099", "India");
        return Arrays.asList(h1, h2, h3, h4, h5);
    }

    public static List<Doctor> getDoctorValues(List<Hospital> hospitals) {
        Doctor d1 = new Doctor("DOC_101", "Dr. Aarav Malhotra", Doctor.Specialization.Orthopedics, hospitals.get(0), 500, 6);
        Doctor d2 = new Doctor("DOC_102", "Dr. Meera Iyer", Doctor.Specialization.Dermatologist, hospitals.get(3), 550, 7);
        Doctor d3 = new Doctor("DOC_103", "Dr. Rohit Verma", Doctor.Specialization.Physician, hospitals.get(1), 600, 8);
        Doctor d4 = new Doctor("DOC_104", "Dr. Rohan Kulkarni", Doctor.Specialization.Dermatologist, hospitals.get(0), 850, 10);
        Doctor d5 = new Doctor("DOC_105", "Dr. Ananya Sen", Doctor.Specialization.Cardiologist, hospitals.get(2), 900, 11);
        Doctor d6 = new Doctor("DOC_106", "Dr. Kunal Shah", Doctor.Specialization.Physician, hospitals.get(1), 950, 13);
        Doctor d7 = new Doctor("DOC_107", "Dr. Priya Nair", Doctor.Specialization.Cardiologist, hospitals.get(0), 750, 9);
        Doctor d8 = new Doctor("DOC_108", "Dr. Sandeep Rao", Doctor.Specialization.Orthopedics, hospitals.get(3), 800, 10);
        Doctor d9 = new Doctor("DOC_109", "Dr. Kavita Joshi", Doctor.Specialization.Orthopedics, hospitals.get(1), 820, 10);
        Doctor d10 = new Doctor("DOC_110", "Dr. Aarav Mehta", Doctor.Specialization.Cardiologist, hospitals.get(3), 1000, 14);
        Doctor d11 = new Doctor("DOC_111", "Dr. Nikhil Bansal", Doctor.Specialization.Dentist, hospitals.get(0), 1100, 15);
        Doctor d12 = new Doctor("DOC_112", "Dr. Sneha Kulkarni", Doctor.Specialization.Physician, hospitals.get(1), 1050, 13);
        Doctor d13 = new Doctor("DOC_113", "Dr. Meera Kapoor", Doctor.Specialization.Physician, hospitals.get(2), 700, 8);
        Doctor d14 = new Doctor("DOC_114", "Dr. Ritu Saxena", Doctor.Specialization.Dermatologist, hospitals.get(0), 720, 9);
        Doctor d15 = new Doctor("DOC_115", "Dr. Ankit Jain", Doctor.Specialization.Dentist, hospitals.get(3), 680, 7);
        Doctor d16 = new Doctor("DOC_116", "Dr. Rahul Menon", Doctor.Specialization.Dermatologist, hospitals.get(1), 600, 6);
        Doctor d17 = new Doctor("DOC_117", "Dr. Pooja Mishra", Doctor.Specialization.Orthopedics, hospitals.get(2), 620, 7);
        Doctor d18 = new Doctor("DOC_118", "Dr. Karan Patel", Doctor.Specialization.Dentist, hospitals.get(0), 500, 5);
        Doctor d19 = new Doctor("DOC_119", "Dr. Neha Gupta", Doctor.Specialization.Physician, hospitals.get(2), 550, 6);
        Doctor d20 = new Doctor("DOC_120", "Dr. Amit Joshi", Doctor.Specialization.Cardiologist, hospitals.get(3), 580, 7);
        return Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20);

    }

    public static List<Patient> getPatientsValues() {
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
        return Arrays.asList(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25
        );

    }

    public static List<AppointmentDTO> getAppointmentValues() {
        AppointmentDTO a1 = new AppointmentDTO("DOC_101", "PAT_101", TimeSlot.startTime.plusHours(9));
        AppointmentDTO a2 = new AppointmentDTO("DOC_105", "PAT_104", TimeSlot.startTime.plusHours(12));
        AppointmentDTO a3 = new AppointmentDTO("DOC_108", "PAT_108", TimeSlot.startTime.plusHours(15));
        AppointmentDTO a4 = new AppointmentDTO("DOC_103", "PAT_110", TimeSlot.startTime.plusHours(20));
        AppointmentDTO a5 = new AppointmentDTO("DOC_110", "PAT_112", TimeSlot.startTime.plusHours(10));
        AppointmentDTO a6 = new AppointmentDTO("DOC_117", "PAT_116", TimeSlot.startTime.plusHours(18));
        AppointmentDTO a7 = new AppointmentDTO("DOC_120", "PAT_119", TimeSlot.startTime.plusHours(20));
        AppointmentDTO a8 = new AppointmentDTO("DOC_114", "PAT_105", TimeSlot.startTime.plusHours(16));
        AppointmentDTO a9 = new AppointmentDTO("DOC_106", "PAT_107", TimeSlot.startTime.plusHours(17));
        AppointmentDTO a10 = new AppointmentDTO("DOC_109", "PAT_103", TimeSlot.startTime.plusHours(21));
        return Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }
}
