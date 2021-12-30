package com.API.OnDriver.RideSubsystem;
import com.API.OnDriver.CustomerSubsystem.Driver;

public interface AreaSubject {
    public void subscribe(Driver driver);

    public void unsubscribe(Driver driver);

    public void notifyDrivers(Ride ride);
}
