package com.my.practo.practo.service;

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

    public void sendEmail() throws IOException {

        Email from = new Email(mail);
        String subject = "Appointment Confirmed";
        Email to = new Email(mail);

        String htmlBody =
                "<html>" +
                        "<body>" +
                        "<h2>Appointment Confirmed</h2>" +
                        "<p>Hi " + "" + ",</p>" +
                        "<p>Your appointment has been successfully booked.</p>" +
                        "<p><b>Doctor:</b> " + "doctorName" + "</p>" +
                        "<p><b>Specialization:</b> " + "specialization" + "</p>" +
                        "<p><b>Date & Time:</b> " + "timing" + "</p>" +
                        "<br/>" +
                        "<p>Thank you for using Practo.</p>" +
                        "<hr/>" +
                        "<small>You are receiving this email because you created an account.</small>" +
                        "</body>" +
                        "</html>";

        Content content = new Content("text/plain", htmlBody);

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        sg.api(request);
    }

}
