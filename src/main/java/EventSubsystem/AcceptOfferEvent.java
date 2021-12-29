package EventSubsystem;

import CustomerSubsystem.Passenger;

public class AcceptOfferEvent extends Event {
    public AcceptOfferEvent(Passenger passenger) {
        setName(EventName.acceptedOffer);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Passenger Name", passenger.getUsername());
    }
}
