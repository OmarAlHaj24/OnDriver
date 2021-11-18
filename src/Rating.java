import java.util.HashMap;

public class Rating {
    HashMap<Ride, Integer> driverRatings = new HashMap<Ride, Integer>();
    int ratingSum;

    public double getAverageRating() {
        Double average = 1.0 * ratingSum / driverRatings.size();
        return average;
    }

    public void addRating(Ride ride, int rating) {

    }

    public void viewAllRating() {

    }
}
