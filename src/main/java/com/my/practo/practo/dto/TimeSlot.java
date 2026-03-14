package com.my.practo.practo.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable


public class TimeSlot {


    @Getter
    private List<LocalDateTime> bookedTimeSlots = new ArrayList<>();
    @Getter
    private List<LocalDateTime> availableTimeSlots = new ArrayList<>();

    public static LocalDateTime startTime = LocalDateTime.parse("2026-02-11T00:00:00.000000");

    public boolean bookTimeSlot(LocalDateTime time) {
        if (!availableTimeSlots.contains(time))
            return false;
        availableTimeSlots.remove(time);
        bookedTimeSlots.add(time);
        return true;
    }

    public TimeSlot() {
        LocalDateTime startTime = TimeSlot.startTime.plusHours(1);
        LocalDateTime endTime = startTime.plusHours(24);
        List<LocalDateTime> availableSlots = new ArrayList<>();
        for (LocalDateTime i = startTime; i.isBefore(endTime); i = i.plusMinutes(30)) {
            if (i.getHour() >= 21 || i.getHour() <= 9 || (i.getHour() >= 13 && i.getHour() <= 15))
                continue;
            availableSlots.add(i);
        }
        this.availableTimeSlots = availableSlots;
    }

}
