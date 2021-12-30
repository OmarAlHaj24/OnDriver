package com.API.OnDriver.CustomerSubsystem;

import com.API.OnDriver.RideSubsystem.Area;
import com.API.OnDriver.RideSubsystem.Ride;
import com.API.OnDriver.DataSubsystem.ListManager;

import java.util.ArrayList;

public class Admin extends User {
    public Admin(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password, UserStatus.admin);
    }

    ListManager manager = ListManager.getInstance();

    public boolean verifyDriver(String username) {
        Driver tempDriver = manager.getDriver(username);
        if (tempDriver == null) {
            return false;
        } else {
            tempDriver.setVerified(true);
            return true;
        }
    }

    public Boolean suspend(String username) {
        User user = manager.getUser(username);
        if (user == null) {
            return false;
        } else {
            user.setUserStatus(UserStatus.suspended);
            return true;
        }
    }

    public ArrayList<String> getSystemRides() {
        boolean flag = false;
        ArrayList<String> areas = new ArrayList<>();
        ArrayList<Ride> allRides = manager.getAllRides();
        for (int i = 0; i < allRides.size(); i++) {
            flag = true;
            areas.add((i + 1) + "- " + allRides.get(i));
        }
        if (!flag) {
            areas.add("No rides yet");
        }
        return areas;
    }

    public ArrayList<String> getRideEvents(int idx) {
        boolean flag = false;
        ArrayList<String> events = new ArrayList<>();
        Ride ride = manager.getRide(idx);
        for (int i = 0; i < ride.getEvents().size(); i++) {
            flag = true;
            events.add(ride.getEvents().get(i).toString());
        }
        if (!flag) {
            events.add("The ride has no events yet");
        }
        return events;
    }

    public void applyDiscount(Area area) {
        area.setDiscounted();
    }
}
