package RideSubsystem;

import CustomerSubsystem.Driver;

import java.util.ArrayList;

public class Area implements AreaSubject {
    private String location;
    private boolean isDiscounted = false;
    ArrayList<Driver> drivers = new ArrayList<Driver>();

    public Area(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted() {
        isDiscounted = true;
    }

    @Override
    public void subscribe(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void unsubscribe(Driver driver) {
        drivers.remove(driver);
    }

    @Override
    public void notifyDrivers(Ride ride) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getCurrentRide() == null && drivers.get(i).getNumberOfPassengers() <= ride.getNumberOfPassengers()) {
                drivers.get(i).update(ride);
            }
        }
    }
}
