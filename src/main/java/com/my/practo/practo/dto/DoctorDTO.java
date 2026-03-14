package com.my.practo.practo.dto;

import com.my.practo.practo.entity.Doctor;
import com.my.practo.practo.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class DoctorDTO {
    private String id;
    private String name;
    private Doctor.Specialization specialization;
    private Hospital hospital;
    private Integer fees;
    private Integer experience;
    private List<LocalDateTime> timeSlots;


}
