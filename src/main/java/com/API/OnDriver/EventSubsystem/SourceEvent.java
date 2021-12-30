package com.API.OnDriver.EventSubsystem;

import com.API.OnDriver.CustomerSubsystem.Driver;
import com.API.OnDriver.RideSubsystem.Ride;

public class SourceEvent extends Event {
    public SourceEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToSource);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
