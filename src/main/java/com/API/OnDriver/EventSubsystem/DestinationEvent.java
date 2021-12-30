package com.API.OnDriver.EventSubsystem;

import com.API.OnDriver.CustomerSubsystem.Driver;
import com.API.OnDriver.RideSubsystem.Ride;

public class DestinationEvent extends Event {
    public DestinationEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToDestination);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
