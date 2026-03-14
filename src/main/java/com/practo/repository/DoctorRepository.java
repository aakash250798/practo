package com.my.practo.practo.repository;

import com.my.practo.practo.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    @Query(value = "SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE %:q% OR LOWER(d.hospital.name) LIKE %:q% ")
    Page<Doctor> searchDoctors(@Param("q") String q, Pageable pageable);
}
