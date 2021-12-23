package com.API.OnDriver;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PassengerController {

    private Ride currentRide;
    private ArrayList <Ride> pastRides;

    @PostMapping("/passenger/request/{currentUsername}")
    public String requestRide(@RequestBody Ride ride,@PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger==null){
            return "You have no access to this functionality!!";
        }

        passenger.requestRide (ride);
        return "Ride was requested successfully";
    }

    @PostMapping("/passenger/rateRide/{currentUsername}/{rate}")
    public String rateRide(@RequestBody Ride ride, @PathVariable int rate, @PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger==null){
            return "You have no access to this functionality!!";
        }
        if (rate <0 || rate>5 ){
            return "Wrong enter of rating!";
        }
        passenger.rateRide ( ride,rate );
        return "ride was successfuly rated";
    }


    @GetMapping("/passenger/viewOffers/{currentUsername}")
    public int viewOffers(@PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger==null){
            return -1;
        } else{
            passenger.checkOffers ();
            return 1;
        }
    }

    @PostMapping("/passenger/acceptOffers/{currentUsername}/{offerNum}")
    public String acceptOffer(@PathVariable String currentUsername, @PathVariable int offerNum) {
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger==null){
            return "You have no access to this functionality!!";
        }
        if (passenger.acceptOffer ( offerNum )){
            return "Offer is accepted successfully";
        };
        return "Offer is not accepted !!";
    }

    @PostMapping("/passenger/viewPastRides/{currentUsername}")
    public String listPastRides(@PathVariable String currentUsername) {
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger==null){
            return "You have no access to this functionality!!";
        }
        passenger.listPastRides ();
        return "All Past rides viewed successfully";
    }


}
