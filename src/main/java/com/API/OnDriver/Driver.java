package com.API.OnDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver extends User implements DriverObserver {
    private String driverLicense;
    private String nationalID;
    private Boolean isVerified = false;
    private List<Area> favouriteAreas;
    private List<Ride> rides;
    private Rating rating;

    public Driver(String username, String mobileNumber, String email, String password, String license, String id) {
        super(username, mobileNumber, email, password, UserStatus.activated);
        driverLicense = license;
        nationalID = id;
        favouriteAreas = new ArrayList<>();
        rides = new ArrayList<>();
        rating = new Rating();
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setFavouriteAreas(List<Area> favouriteAreas) {
        this.favouriteAreas = favouriteAreas;
    }

    public List<Area> getFavouriteAreas() {
        return favouriteAreas;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public void suggestOffer(int idx, Offer offer) {
        Ride ride = rides.get(idx);
        ride.addOffer(offer);
    }

    public ArrayList<String> viewRides(int index) {
        boolean flag = false;
        ArrayList<String> ridesPrint = new ArrayList<>();
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getSource().equals(favouriteAreas.get(index)) && !rides.get(i).getAccepted()) {
                ridesPrint.add((i + 1) + "- " + rides.get(i));
                flag = true;
            }
        }
        if (!flag) {
            ridesPrint.add("There isn't any requested rides in area");
        }
        return ridesPrint;
    }

    public ArrayList<String> viewRating() {
        ArrayList<String> ratings = rating.viewAllRating();
        if (ratings.size() == 0)
            ratings.add("There is not any ratings for you yet");
        return ratings;
    }

    public void addFavArea(Area area) {
        favouriteAreas.add(area);
        area.subscribe(this);
    }

    public ArrayList<String> listFavouriteAreas() {
        boolean flag = false;
        ArrayList<String> areas = new ArrayList<>();
        for (int i = 0; i < favouriteAreas.size(); i++) {
            flag = true;
            //String temp = (i+1) + favouriteAreas.get(i).getLocation();
            areas.add((i + 1) + "- " + favouriteAreas.get(i).getLocation());
        }
        if (!flag) {
            areas.add("No favourite areas");
        }
        return areas;
    }

    @Override
    public void update(Ride ride) {
        rides.add(ride);
    }

    @Override
    public String toString() {
        return super.toString() + "Driver License: " + getDriverLicense() + "\n" + "National ID: " + getNationalID() + "\n";
    }

}
