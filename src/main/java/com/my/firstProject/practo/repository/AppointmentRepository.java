package com.my.firstProject.practo.repository;

import com.my.firstProject.practo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {
}
