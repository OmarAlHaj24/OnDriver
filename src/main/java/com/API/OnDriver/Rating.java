package com.API.OnDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rating {
    private HashMap<Ride, Integer> driverRatings = new HashMap<Ride, Integer>();
    private int ratingSum = 0;

    public double getAverageRating() {
        if (driverRatings.size() == 0) {
            return 0;
        }
        return 1.0 * ratingSum / driverRatings.size();
    }

    public void addRating(Ride ride, int rating) {
        driverRatings.put(ride, rating);
        ratingSum += rating;
    }

    public ArrayList<String> viewAllRating() {
        ArrayList<String> ratings = new ArrayList<>();
        for (Map.Entry<Ride, Integer> set : driverRatings.entrySet()) {
            ratings.add(set.getKey().getPassenger().getUsername() + " : " + set.getValue());
        }
        return ratings;
    }
}
