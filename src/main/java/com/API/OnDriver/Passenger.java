package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Passenger extends User {
    private ArrayList<Ride> pastRides;
    private Ride currentRide;

    public Passenger(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password, UserStatus.activated);
        pastRides = new ArrayList<>();
        currentRide = null;
    }

    public void setPastRides(ArrayList<Ride> pastRides) {
        this.pastRides = pastRides;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void requestRide(Ride ride) {
        ListManager.getInstance().addRide(ride);
        ride.getSource().notifyDrivers(ride);
        currentRide = ride;
    }

    public boolean rateRide(Ride ride, int rate) {
        if (rate < 1 || rate > 5) {
            return false;
        }
        for (int i = 0; i < pastRides.size(); i++) {
            if (pastRides.get(i).equals(ride)) { //We may need to overload the "equals" function later on..."
                pastRides.get(i).getAcceptedOffer().getDriver().getRating().addRating(ride, rate);
            }
        }
        return true;
    }

    public double getRating(String username) {
        double avgRating = -1;
        for (int i = 0; i < currentRide.getOffers().size(); i++) {
            if (currentRide.getOffers().get(i).getDriver().getUsername().equals(username)) {
                avgRating = currentRide.getOffers().get(i).getDriver().getRating().getAverageRating();
            }
        }
        return avgRating;
    }

    public ArrayList<String> checkOffers() {
        return currentRide.viewOffers();
    }

    public boolean acceptOffer(int offerNum) {
        if (offerNum >= currentRide.getOffers().size() || offerNum < 0) {
            return false;
        }
        Offer accepted = currentRide.getOffers().get(offerNum);
        currentRide.setAcceptedOffer(accepted);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Event event = new Event();
        event.setName(EventName.acceptedOffer);
        event.addAttribute("Time", dtf.format(now));
        event.addAttribute("Passenger Name", getUsername());
        currentRide.addEvent(event);
        accepted.getDriver().setCurrentRide(currentRide);
        pastRides.add(currentRide);
        currentRide = null;
        return true;
    }

    public ArrayList<String> listPastRides() {
        boolean flag = false;
        ArrayList<String> rides = new ArrayList<>();
        for (int i = 0; i < pastRides.size(); i++) {
            String temp = i + "- " + pastRides.get(i).toStringPassenger();
            rides.add(temp);
            flag = true;
        }
        if (!flag) {
            rides.add("There's no past rides");
        }
        return rides;
    }

    public Ride getPastRide(int index) {
        return pastRides.get(index);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
