package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AcceptOfferEvent extends Event {
    AcceptOfferEvent(Passenger passenger) {
        setName(EventName.acceptedOffer);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Passenger Name", passenger.getUsername());
    }
}
