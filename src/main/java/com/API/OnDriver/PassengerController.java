package com.API.OnDriver;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PassengerController {

    private Ride currentRide;
    private ArrayList <Ride> pastRides;

    @PostMapping("/passenger/request/{currentUsername}/{source}/{destination}")
    public String requestRide(@PathVariable String currentUsername, @PathVariable Area source, @PathVariable Area destination){
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger == null){
            return "You have no access to this functionality!!";
        }
        Ride ride = new Ride ( source,destination,passenger );
        passenger.requestRide ( ride );
        return "Ride was requested successfully";
    }

    @GetMapping("/passenger/viewPastRides/{currentUsername}")
    public ArrayList<String> listPastRides(@PathVariable String currentUsername){
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        ArrayList<String> rides = new ArrayList <> ();
        if (passenger == null){
            rides.add( "You have no access to this functionality!!");
            return rides;
        }
        rides = passenger.listPastRides ();
        return rides;
    }

    @PostMapping("/passenger/rateRide/{currentUsername}/{rate}")
    public String rateRide(@PathVariable String currentUsername,@PathVariable int indexRide ,@PathVariable int rate){
        Passenger passenger = IdentityManager.getPassenger ( currentUsername );
        if (passenger == null){
            return "You have no access to this functionality!!";
        }
        Ride temp = passenger.getPastRide ( indexRide );
        passenger.rateRide ( temp,rate );
        return "ride was rated successfully";
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


}
