package com.API.OnDriver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class DriverController {
    @PostMapping("/driver/addFavouriteArea/{currentUsername}/{areaName}")
    public String addFavouriteArea(@PathVariable String currentUsername, @PathVariable String areaName) {
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null)
            return "You're either not logged in or you have no access to this function";
        Area area = ListManager.getInstance().getArea(areaName);
        driver.addFavArea(area);
        return "Area added successfully";
    }

    @PostMapping("/driver/ListFavouriteArea/{currentUsername}")
    public ArrayList<String> listFavouriteAreas(@PathVariable String currentUsername) {
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You're either not logged in or you have no access to this function");
            return temp;
        }
        return driver.listFavouriteAreas();
    }


    @PostMapping("/driver/viewRides/{currentUsername}/{areaNum}")
    public ArrayList<String> viewRide(@PathVariable String currentUsername, @PathVariable int areaNum) {
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You're either not logged in or you have no access to this function");
            return temp;
        }
        return driver.viewRides(areaNum);
    }

    @PostMapping("/driver/suggestOffer/{currentUsername}/{rideNum}/{offerPrice}")
    public String suggestOffer(@PathVariable String currentUsername, @PathVariable int rideNum, @PathVariable double offerPrice) {
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null)
            return "You're either not logged in or you have no access to this function";
        Offer offer = new Offer(offerPrice, driver);
        driver.suggestOffer(rideNum, offer);
        return "Your offer was sent successfully. Please wait for the passenger's response";
    }

    @PostMapping("/driver/viewRating/{currentUsername}")
    public ArrayList<String> viewRating(@PathVariable String currentUsername) {
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You're either not logged in or you have no access to this function");
            return temp;
        }
        return driver.viewRating();
    }

    @PostMapping("/driver/startRide/{currentUsername}")
    public String startRide(@PathVariable String currentUsername){
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null)
            return "You're either not logged in or you have no access to this function";
        if(driver.startRide()){
            return "Ride started successfully";
        }else{
            return "You have no current rides";
        }
    }

    @PostMapping("/driver/endRide/{currentUsername}")
    public String endRide(@PathVariable String currentUsername){
        Driver driver = IdentityManager.getDriver(currentUsername);
        if (driver == null)
            return "You're either not logged in or you have no access to this function";
        if(driver.endRide()){
            return "Ride ended successfully";
        }else{
            return "You have no current rides";
        }
    }
}
