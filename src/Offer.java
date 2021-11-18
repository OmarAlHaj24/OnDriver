public class Offer {
    private double price;
    private Driver driver;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "price: " + price +
                ", driver name: " + driver.getUsername() + ", driver phone number: " + driver.getMobileNumber()
                +", driver license" + driver.getDriverLicense() + ", driver average rating: " + driver.getRating().getAverageRating();
    }
}
