package EventSubsystem;

import CustomerSubsystem.Passenger;

public class AcceptOfferEvent extends Event {
    AcceptOfferEvent(Passenger passenger) {
        setName(EventName.acceptedOffer);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Passenger Name", passenger.getUsername());
    }
}
