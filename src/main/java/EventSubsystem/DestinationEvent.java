package EventSubsystem;

import CustomerSubsystem.Driver;
import RideSubsystem.Ride;

public class DestinationEvent extends Event {
    public DestinationEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToDestination);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
