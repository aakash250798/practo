package com.my.practo.practo.service;

import com.my.practo.practo.dto.AppointmentDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationService {

    @Value("${mailApiKey}")
    private String apiKey;

    @Value("${mail}")
    private String mail;

    public void sendEmail(AppointmentDTO appointmentDTO) throws IOException {

        Email from = new Email(mail);
        String subject = "Appointment Confirmed";
        Email to = new Email(mail);

        String htmlBody =
                "<html>" +
                        "<body style='font-family: Arial, sans-serif; background:#f5f7fa; padding:20px;'>" +

                        "<table align='center' width='600' style='background:white;padding:30px;border-radius:8px;'>" +

                        "<tr><td style='text-align:center;'>" +
                        "<h2 style='color:#2c3e50;'>Appointment Confirmed</h2>" +
                        "</td></tr>" +

                        "<tr><td>" +
                        "<p>Hi <b>" + appointmentDTO.getPatientName() + "</b>,</p>" +
                        "<p>Your appointment has been successfully booked.</p>" +
                        "</td></tr>" +

                        "<tr><td>" +
                        "<table width='100%' style='border-collapse:collapse;font-size:15px;'>" +

                        "<tr>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'><b>Doctor</b></td>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'>" + appointmentDTO.getDoctorName() + "</td>" +
                        "</tr>" +

                        "<tr>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'><b>Specialization</b></td>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'>" + appointmentDTO.getSpecialization() + "</td>" +
                        "</tr>" +

                        "<tr>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'><b>Date & Time</b></td>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'>" + appointmentDTO.getTiming() + "</td>" +
                        "</tr>" +

                        "<tr>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'><b>Hospital</b></td>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'>" + appointmentDTO.getHospital() + "</td>" +
                        "</tr>" +

                        "<tr>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'><b>Consultation Fees</b></td>" +
                        "<td style='padding:8px;border-bottom:1px solid #eee;'>₹" + appointmentDTO.getFees() + "</td>" +
                        "</tr>" +

                        "<tr>" +
                        "<td style='padding:8px;'><b>Appointment ID</b></td>" +
                        "<td style='padding:8px;'>" + appointmentDTO.getAppointmentId() + "</td>" +
                        "</tr>" +

                        "</table>" +
                        "</td></tr>" +

                        "<tr><td style='padding-top:25px;'>" +
                        "<p>Thank you for using <b>Practo</b>.</p>" +
                        "<hr style='border:none;border-top:1px solid #eee;'/>" +
                        "<small style='color:#777;'>You are receiving this email because you booked an appointment.</small>" +
                        "</td></tr>" +

                        "</table>" +
                        "</body>" +
                        "</html>";

        Content content = new Content("text/html", htmlBody);

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        sg.api(request);
    }

}
