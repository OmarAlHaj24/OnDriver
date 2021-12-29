package EventSubsystem;

import CustomerSubsystem.Driver;
import EventSubsystem.Event;
import EventSubsystem.EventName;
import EventSubsystem.IDateTime;
import RideSubsystem.Ride;

public class DestinationEvent extends Event {
    DestinationEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToDestination);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
