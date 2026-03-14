package com.my.practo.practo.repository;

import com.my.practo.practo.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,String> {
}
