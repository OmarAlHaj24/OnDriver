package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SourceEvent extends Event {
    SourceEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToSource);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
