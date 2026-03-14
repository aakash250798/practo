package com.my.practo.practo.service;

import com.my.practo.practo.configuration.RabbitMQConfig;
import com.my.practo.practo.dto.AppointmentDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventListener {

    private final NotificationService notificationService;

    public AppointmentEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleAppointmentBooked(AppointmentDTO dto) {
        notificationService.sendAppointmentNotification(dto);
    }
}