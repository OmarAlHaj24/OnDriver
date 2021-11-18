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

    public void rateRide(Ride ride, int rate) {
        for (int i = 0; i < pastRides.size(); i++) {
            if (pastRides.get(i).equals(ride)) {
                pastRides.get(i).getAcceptedOffer().getDriver().getRating().addRating(ride, rate);
            }
        }
    }

    public double getRating(String username) {
        double avgRating = 0;
        for (int i = 0; i < pastRides.size(); i++) {
            if (pastRides.get(i).getAcceptedOffer().getDriver().getUsername().equals(username)) {
                avgRating = pastRides.get(i).getAcceptedOffer().getDriver().getRating().getAverageRating();
            }
        }
        return avgRating;
    }

    public void checkOffers() {
        currentRide.viewOffers();
    }

    public void acceptOffer(int offerNum) {
        Offer accepted = currentRide.getOffers().get(offerNum);
        currentRide.setAcceptedOffer(accepted);
        pastRides.add(currentRide);
        currentRide = null;
    }

    public void listPastRides() {
        for (int i = 0; i < pastRides.size(); i++) {
            System.out.println(i + "- " + pastRides.get(i));
        }
    }

    public Ride getPastRide(int index) {
        return pastRides.get(index);
    }
}
