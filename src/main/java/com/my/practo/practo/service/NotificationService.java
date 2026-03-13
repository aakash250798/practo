package com.my.practo.practo.service;

import com.my.practo.practo.configuration.RabbitMQConfig;
import com.my.practo.practo.dto.AppointmentDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
public class NotificationService {

    @Value("${mail}")
    private String mail;


    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleAppointmentBooked(AppointmentDTO dto) throws IOException {
        sendEmail(dto);
    }

    private final SendGrid sendGrid;
    private final TemplateEngine templateEngine;

    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public NotificationService(SendGrid sendGrid, TemplateEngine templateEngine) {
        this.sendGrid = sendGrid;
        this.templateEngine = templateEngine;
    }

    public void sendEmail(AppointmentDTO appointmentDTO) throws IOException {

        Email from = new Email(mail);
        String subject = "Appointment Confirmed";
        Email to = new Email(mail);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");

        appointmentDTO.getTiming().format(formatter);

        Context context = new Context();
        context.setVariable("patientName", appointmentDTO.getPatientName());
        context.setVariable("doctorName", appointmentDTO.getDoctorName());
        context.setVariable("specialization", appointmentDTO.getSpecialization());
        context.setVariable("hospital", appointmentDTO.getHospital());
        context.setVariable("fees", appointmentDTO.getFees());
        context.setVariable("appointmentId", appointmentDTO.getAppointmentId());
        context.setVariable("timing", appointmentDTO.getTiming().format(formatter));

        String html = templateEngine.process("email", context);

        Content content = new Content("text/html", html);

        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        sendGrid.api(request);

    }

}
