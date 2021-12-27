package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AcceptOfferEvent extends Event {
    AcceptOfferEvent(Passenger passenger) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        setName(EventName.acceptedOffer);
        addAttribute("Time", dtf.format(now));
        addAttribute("Passenger Name", passenger.getUsername());
    }
}
