package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MakeOfferEvent extends Event {
    MakeOfferEvent(Driver driver, Offer offer) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        setName(EventName.addedPrice);
        addAttribute("Time", dtf.format(now));
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Offered Price", Double.toString(offer.getPrice()));
    }
}
