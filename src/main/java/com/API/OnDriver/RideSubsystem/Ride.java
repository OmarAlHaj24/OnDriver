package com.API.OnDriver.RideSubsystem;

import com.API.OnDriver.EventSubsystem.Event;
import com.API.OnDriver.CustomerSubsystem.Passenger;

import java.util.ArrayList;

public class Ride {
    private Area source;
    private Area destination;
    private Passenger passenger;
    private Offer acceptedOffer;
    private ArrayList<Offer> offers = new ArrayList<>();
    private Boolean isAccepted = false;
    private ArrayList<Event> events = new ArrayList<>();
    private int numberOfPassengers;

    public Ride(Area source, Area destination, Passenger passenger, int numberOfPassengers) {
        this.source = source;
        this.passenger = passenger;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        acceptedOffer = null;
    }

    public Area getSource() {
        return source;
    }

    public Area getDestination() {
        return destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setAcceptedOffer(Offer acceptedOffer) {
        isAccepted = true;
        this.acceptedOffer = acceptedOffer;
    }

    public Offer getAcceptedOffer() {
        return acceptedOffer;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void addOffer(Offer offer) {
        offer.applyDiscount(this);
        offers.add(offer);
    }

    public ArrayList<String> viewOffers() {
        boolean flag = false;
        ArrayList<String> offers_ = new ArrayList<>();
        for (int i = 0; i < offers.size(); i++) {
            flag = true;
            offers_.add((i + 1) + "- " + offers.get(i));
        }
        if (!flag) {
            offers_.add("No offers yet");
        }
        return offers_;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public String toString() {
        return "Source: " + source.getLocation() + " || " + "Destination: " + destination.getLocation() + " || Passenger username: " +
                passenger.getUsername() + " || Passenger phone number: " + passenger.getMobileNumber();
    }

    public String toStringPassenger() {
        return "Source: " + source.getLocation() + " || " + "Destination: " + destination.getLocation() + " || Driver username: " +
                acceptedOffer.getDriver().getUsername() + " || driver phone number: " + acceptedOffer.getDriver().getMobileNumber()
                + " || driver license: " + acceptedOffer.getDriver().getDriverLicense() + " || driver average rating: " + acceptedOffer.getDriver().getRating().getAverageRating();
    }
}
