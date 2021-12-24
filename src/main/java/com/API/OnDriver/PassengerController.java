package com.API.OnDriver;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PassengerController {
    ListManager manager = ListManager.getInstance();

    @PostMapping("/passenger/request/{currentUsername}/{source}/{destination}/{numberOfPassengers}")
    public String requestRide(@PathVariable String currentUsername, @PathVariable String source, @PathVariable String destination, @PathVariable int numberOfPassengers) {
        Passenger passenger = IdentityManager.getPassenger(currentUsername);
        if (passenger == null) {
            return "You're either not logged in or you have no access to this function";
        }
        Area source_ = manager.getArea(source);
        Area destination_ = manager.getArea(destination);
        Ride ride = new Ride(source_, destination_, passenger, numberOfPassengers);
        passenger.requestRide(ride);
        return "Ride was requested successfully";
    }

    @GetMapping("/passenger/viewPastRides/{currentUsername}")
    public ArrayList<String> listPastRides(@PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger(currentUsername);
        if (passenger == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You're either not logged in or you have no access to this function");
            return temp;
        }
        return passenger.listPastRides();
    }

    @PostMapping("/passenger/rateRide/{currentUsername}/{rideIdx}/{rate}")
    public String rateRide(@PathVariable String currentUsername, @PathVariable int rideIdx, @PathVariable int rate) {
        Passenger passenger = IdentityManager.getPassenger(currentUsername);
        if (passenger == null) {
            return "You're either not logged in or you have no access to this function";
        }
        Ride temp = passenger.getPastRide(rideIdx);
        passenger.rateRide(temp, rate);
        return "Ride was rated successfully";
    }

    @GetMapping("/passenger/viewOffers/{currentUsername}")
    public ArrayList<String> viewOffers(@PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger(currentUsername);
        if (passenger == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You're either not logged in or you have no access to this function");
            return temp;
        } else {
            return passenger.checkOffers();
        }
    }

    @PostMapping("/passenger/acceptOffers/{currentUsername}/{offerNum}")
    public String acceptOffer(@PathVariable String currentUsername, @PathVariable int offerNum) {
        Passenger passenger = IdentityManager.getPassenger(currentUsername);
        if (passenger == null) {
            return "You're either not logged in or you have no access to this function";
        }
        if (passenger.acceptOffer(offerNum)) {
            return "Offer is accepted successfully";
        }
        return "Offer was not accepted, you may have entered a wrong offer number";
    }
}
