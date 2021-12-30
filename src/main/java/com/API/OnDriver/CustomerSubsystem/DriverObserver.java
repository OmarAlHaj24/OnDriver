package com.API.OnDriver.CustomerSubsystem;

import com.API.OnDriver.RideSubsystem.Ride;

public interface DriverObserver {
    public void update(Ride ride);
}
