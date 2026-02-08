package com.my.firstProject.practo.repository;

import com.my.firstProject.practo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
