package com.API.OnDriver;

public class SourceEvent extends Event {
    SourceEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToSource);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
