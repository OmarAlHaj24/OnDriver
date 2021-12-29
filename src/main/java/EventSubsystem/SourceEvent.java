package EventSubsystem;

import CustomerSubsystem.Driver;
import RideSubsystem.Ride;

public class SourceEvent extends Event {
    public SourceEvent(Driver driver, Ride ride) {
        setName(EventName.arrivedToSource);
        addAttribute("Time", IDateTime.getInstance().getDateTime());
        addAttribute("Driver Name", driver.getUsername());
        addAttribute("Passenger Name", ride.getPassenger().getUsername());
    }
}
