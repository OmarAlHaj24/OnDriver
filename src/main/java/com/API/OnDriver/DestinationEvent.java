package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DestinationEvent extends Event {
    DestinationEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToDestination);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
