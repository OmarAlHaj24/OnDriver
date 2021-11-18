import java.util.ArrayList;

public class Area implements AreaSubject {
    private String location;
    ArrayList<Driver> drivers = new ArrayList<Driver>();

    public Area(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
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
            drivers.get(i).update(ride);
        }
    }
}
