package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MakeOfferEvent extends Event {
    MakeOfferEvent(Driver driver, Offer offer) {
        setName(EventName.addedPrice);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Offered Price", Double.toString(offer.getPrice()));
    }
}
