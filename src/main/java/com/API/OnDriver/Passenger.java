package com.API.OnDriver;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends User {
    private ArrayList<Ride> pastRides;
    private Ride currentRide;

    public Passenger(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password, UserStatus.activated);
        pastRides = new ArrayList<Ride>();
        currentRide = null;
    }

    public void setPastRides(ArrayList<Ride> pastRides) {
        this.pastRides = pastRides;
    }

    public List<Ride> getPastRides() {
        return pastRides;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void requestRide(Ride ride) {
        ride.getSource().notifyDrivers(ride);
        currentRide = ride;
    }

    public boolean rateRide(Ride ride, int rate) {
        if(rate<1 || rate > 5){
            return false;
        }
        for (int i = 0; i < pastRides.size(); i++) {
            if (pastRides.get(i).equals(ride)) { //We may need to overload the "equals" function later on..."
                pastRides.get(i).getAcceptedOffer().getDriver().getRating().addRating(ride, rate);
            }
        }
        return true;
    }

    public double getRating(String username){
        double avgRating = -1;
        for(int i = 0; i < currentRide.getOffers().size(); i++){
            if(currentRide.getOffers().get(i).getDriver().getUsername().equals(username)){
                avgRating = currentRide.getOffers().get(i).getDriver().getRating().getAverageRating();
            }
        }
        return avgRating;
    }

    public void checkOffers() {
        currentRide.viewOffers();
    }

    public boolean acceptOffer(int offerNum) {
        if(offerNum >= currentRide.getOffers().size() || offerNum < 0){
            return false;
        }
        Offer accepted = currentRide.getOffers().get(offerNum);
        currentRide.setAcceptedOffer(accepted);
        pastRides.add(currentRide);
        currentRide = null;
        return true;
    }

    public boolean listPastRides() {
        boolean flag = false;
        for (int i = 0; i < pastRides.size(); i++) {
            System.out.println(i + "- " + pastRides.get(i).toStringPassenger());
            flag = true;
        }
        return flag;
    }

    public Ride getPastRide(int index) {
        return pastRides.get(index);
    }

    @Override
    public String toString(){
        return  super.toString ();
    }
}