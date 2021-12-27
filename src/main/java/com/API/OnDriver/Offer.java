package com.API.OnDriver;

import java.time.LocalDate;
import java.util.Date;

public class Offer {
    private double price;
    private double discountedPrice;
    private Driver driver;

    public Offer(double price, Driver driver) {
        this.driver = driver;
        this.price = price;
        discountedPrice = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void makeDiscount(int percentage) {
        discountedPrice -= 1.0 * price * percentage / 100;
        discountedPrice = Math.max(0.0, discountedPrice);
    }

    public void applyDiscount(Ride ride) {
        if (ride.getPassenger().isFirstRide()) {
            makeDiscount(10);
        }
        if (ride.getDestination().isDiscounted()) {
            makeDiscount(10);
        }
        if (ride.getNumberOfPassengers() >= 2) {
            makeDiscount(5);
        }
        if (IDateTime.getInstance().isWeekend(new Date())) {
            makeDiscount(5);
        }
        if (ride.getPassenger().getDateOfBirth().substring(4).equals(LocalDate.now().toString().substring(4))) {
            makeDiscount(10);
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "price: " + discountedPrice +
                " || driver name: " + driver.getUsername() + " || driver phone number: " + driver.getMobileNumber()
                + " || driver license: " + driver.getDriverLicense() + " || driver average rating: " + driver.getRating().getAverageRating();
    }
}
