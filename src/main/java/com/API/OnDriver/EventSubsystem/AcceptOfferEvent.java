package com.API.OnDriver.EventSubsystem;

import com.API.OnDriver.CustomerSubsystem.Passenger;

public class AcceptOfferEvent extends Event {
    public AcceptOfferEvent(Passenger passenger) {
        setName(EventName.acceptedOffer);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Passenger Name", passenger.getUsername());
    }
}
