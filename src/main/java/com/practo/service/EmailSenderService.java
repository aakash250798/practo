package com.my.practo.practo.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSenderService {

    @Value("${spring.mail.username}")
    private String fromMail;

    private final JavaMailSender mailSender;

    private final Logger logger = org.slf4j.LoggerFactory.getLogger("");

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String subject, String toMail, String html) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setSubject(subject);
            helper.setTo(toMail);
            helper.setFrom(fromMail);
            helper.setText(html, true);
            mailSender.send(message);

        } catch (MessagingException e) {
            logger.error("Error occurred while sending mail {}", e.getMessage());
        }

    }
}