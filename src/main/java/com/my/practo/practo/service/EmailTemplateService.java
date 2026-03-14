package com.my.practo.practo.service;

import com.my.practo.practo.dto.AppointmentDTO;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.format.DateTimeFormatter;

@Service
public class EmailTemplateService {

    private final TemplateEngine templateEngine;

    public EmailTemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildAppointmentTemplate(AppointmentDTO dto) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");

        Context context = new Context();
        context.setVariable("patientName", dto.getPatientName());
        context.setVariable("doctorName", dto.getDoctorName());
        context.setVariable("specialization", dto.getSpecialization());
        context.setVariable("hospital", dto.getHospital());
        context.setVariable("fees", dto.getFees());
        context.setVariable("appointmentId", dto.getAppointmentId());
        context.setVariable("timing", dto.getTiming().format(formatter));

        return templateEngine.process("email", context);
    }
}