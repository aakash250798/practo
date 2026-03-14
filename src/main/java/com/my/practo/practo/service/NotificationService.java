package com.my.practo.practo.service;

import com.my.practo.practo.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Value("${spring.mail.username}")
    private String toMail;

    private final EmailTemplateService templateService;
    private final EmailSenderService emailSenderService;

    public NotificationService(EmailTemplateService templateService,
                               EmailSenderService emailSenderService) {
        this.templateService = templateService;
        this.emailSenderService = emailSenderService;
    }

    public void sendAppointmentNotification(AppointmentDTO dto) {

        String html = templateService.buildAppointmentTemplate(dto);

        emailSenderService.sendEmail(
                "Appointment Confirmed",
                toMail,
                html
        );
    }
}