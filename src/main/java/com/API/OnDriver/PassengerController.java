package com.API.OnDriver;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PassengerController {

    private Ride currentRide;
    private ArrayList <Ride> pastRides;


    @PostMapping("/passenger/request")
    public String requestRide(@RequestBody Ride ride) {
        ride.getSource().notifyDrivers(ride);
        currentRide = ride;
        return "Ride was requested successfully";
    }

    @PostMapping("/passenger/rateRide/{rate}")
    public int rateRide(@RequestBody Ride ride, @PathVariable int rate) {
        if(rate<1 || rate > 5){
            return -1;
        }
        for (int i = 0; i < pastRides.size(); i++) {
            if (pastRides.get(i).equals(ride)) { //We may need to overload the "equals" function later on..."
                pastRides.get(i).getAcceptedOffer().getDriver().getRating().addRating(ride, rate);
            }
        }
        return 0;
    }

    @GetMapping("/passenger/checkOffers")
    public Ride checkOffers() {
        return currentRide.viewOffers();
    }

    @PostMapping("/passenger/acceptOffers/{offerNum}")
    public String acceptOffer(@PathVariable int offerNum) {
        if(offerNum >= currentRide.getOffers().size() || offerNum < 0){
            return "Failed to accept offer !!";
        }
        Offer accepted = currentRide.getOffers().get(offerNum);
        currentRide.setAcceptedOffer(accepted);
        pastRides.add(currentRide);
        currentRide = null;
        return "Offer was accepted successfully";
    }

    @PostMapping("/passenger/viewPastRides")
    public String listPastRides() {
        boolean flag = false;
        for (int i = 0; i < pastRides.size(); i++) {
            return pastRides.get ( i ).toStringPassenger ();
        }
        return "All Past rides viewed successfully";
    }


}
