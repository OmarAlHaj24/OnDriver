package com.API.OnDriver;

import java.util.ArrayList;
import java.util.List;

public class ListManager implements DataManager {
    private static ListManager instance = null;
    private ArrayList<Passenger> listOfPassengers;
    private ArrayList<Driver> listOfDrivers;
    private ArrayList<Area> listOfAreas;
    private ArrayList<Admin> listOfAdmin;
    private ArrayList<Ride> listOfRides;

    private ListManager() {
        listOfPassengers = new ArrayList<Passenger>();
        listOfDrivers = new ArrayList<>();
        listOfAreas = new ArrayList<>();
        listOfAdmin = new ArrayList<>();
    }

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    @Override
    public Boolean isAvailable(String userName) {
        for (int i = 0; i < listOfAdmin.size(); i++) {
            if (userName.equals(listOfAdmin.get(i).getUsername())) {
                return false;
            }
        }

        for (int i = 0; i < listOfPassengers.size(); i++) {
            if (userName.equals(listOfPassengers.get(i).getUsername())) {
                return false;
            }
        }

        for (int i = 0; i < listOfDrivers.size(); i++) {
            if (userName.equals(listOfDrivers.get(i).getUsername())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Driver> listAllPendingDrivers() {
        List<Driver> pendingDrivers = new ArrayList<>();
        for (int i = 0; i < listOfDrivers.size(); i++) {
            if (!listOfDrivers.get(i).getVerified()) {
                pendingDrivers.add(listOfDrivers.get(i));
            }
        }
        return pendingDrivers;
    }

    @Override
    public User getUser(String userName) {
        for (int i = 0; i < listOfAdmin.size(); i++) {
            if (userName.equals(listOfAdmin.get(i).getUsername())) {
                return listOfAdmin.get(i);
            }
        }

        for (int i = 0; i < listOfPassengers.size(); i++) {
            if (userName.equals(listOfPassengers.get(i).getUsername())) {
                return listOfPassengers.get(i);
            }
        }

        for (int i = 0; i < listOfDrivers.size(); i++) {
            if (userName.equals(listOfDrivers.get(i).getUsername())) {
                return listOfDrivers.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean addToPassenger(Passenger passenger) {
        if (listOfPassengers.contains(passenger)) {
            return false;
        } else {
            listOfPassengers.add(passenger);
            return true;
        }
    }

    @Override
    public Passenger getPassenger(String userName) {
        for (int i = 0; i < listOfPassengers.size(); i++) {
            if (userName.equals(listOfPassengers.get(i).getUsername())) {
                return listOfPassengers.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean addToDriver(Driver driver) {
        if (listOfDrivers.contains(driver)) {
            return false;
        } else {
            listOfDrivers.add(driver);
            return true;
        }
    }

    @Override
    public Driver getDriver(String userName) {
        for (int i = 0; i < listOfDrivers.size(); i++) {
            if (userName.equals(listOfDrivers.get(i).getUsername())) {
                return listOfDrivers.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean addToArea(Area area) {
        if (listOfAreas.contains(area)) {
            return false;
        } else {
            listOfAreas.add(area);
            return true;
        }
    }

    @Override
    public Area getArea(String location) {
        for (int i = 0; i < listOfAreas.size(); i++) {
            if (location.equals(listOfAreas.get(i).getLocation())) {
                return listOfAreas.get(i);
            }
        }
        Area area = new Area(location);
        listOfAreas.add(area);
        return area;
    }

    @Override
    public Boolean addToAdmin(Admin admin) {
        if (listOfAdmin.contains(admin)) {
            return false;
        } else {
            listOfAdmin.add(admin);
            return true;
        }
    }

    @Override
    public Admin getAdmin(String username) {
        for (int i = 0; i < listOfAdmin.size(); i++) {
            if (username.equals(listOfAdmin.get(i).getUsername())) {
                return listOfAdmin.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Ride> getAllRides(){
        return listOfRides;
    }

    @Override
    public Ride getRide(int idx){
        return listOfRides.get(idx - 1);
    }

    @Override
    public void addRide(Ride ride){
        listOfRides.add(ride);
    }
}
