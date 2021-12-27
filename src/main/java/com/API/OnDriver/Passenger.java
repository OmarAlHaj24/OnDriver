package com.API.OnDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passenger extends User {
    private ArrayList<Ride> pastRides;
    private Ride currentRide;
    private String dateOfBirth;

    public Passenger(String username, String mobileNumber, String email, String password, String dateOfBirth) {
        super(username, mobileNumber, email, password, UserStatus.activated);
        pastRides = new ArrayList<>();
        currentRide = null;
        this.dateOfBirth = dateOfBirth;
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

    public ArrayList<String> checkOffers() {
        return currentRide.viewOffers();
    }

    public boolean acceptOffer(int offerNum) {
        if (offerNum >= currentRide.getOffers().size() || offerNum < 0) {
            return false;
        }
        Offer accepted = currentRide.getOffers().get(offerNum);
        currentRide.setAcceptedOffer(accepted);
        currentRide.addEvent(new AcceptOfferEvent(this));
        accepted.getDriver().setCurrentRide(currentRide);
        pastRides.add(currentRide);
        currentRide = null;
        return true;
    }

    public ArrayList<String> listPastRides() {
        boolean flag = false;
        ArrayList<String> rides = new ArrayList<>();
        for (int i = 0; i < pastRides.size(); i++) {
            String temp = (i + 1) + "- " + pastRides.get(i).toStringPassenger();
            rides.add(temp);
            flag = true;
        }
        if (!flag) {
            rides.add("There's no past rides");
        }
        return rides;
    }

    public boolean isFirstRide() {
        return (pastRides.size() == 0);
    }

    public Ride getPastRide(int index) {
        return pastRides.get(index);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
