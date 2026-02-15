package com.my.practo.practo.repository;

import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.entity.Doctor;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DoctorRepositoryCustom {
    List<Doctor> search(RequestDTO dto, Sort sort);
}