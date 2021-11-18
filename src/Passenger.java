import java.util.ArrayList;
import java.util.List;

public class Passenger extends User{
    private ArrayList<Ride>pastRides;
    private Ride currentRide;

    public Passenger(String username, String mobileNumber, String email, String password) {
        super (username, mobileNumber, email, password, UserStatus.activated);
        pastRides = new ArrayList<Ride>();
    }

    public void setPastRides(ArrayList<Ride> pastRides) {
        this.pastRides=pastRides;
    }
    public List<Ride> getPastRides() {
        return pastRides;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide=currentRide;
    }
    public Ride getCurrentRide() {
        return currentRide;
    }

    public void requestRide(Ride ride){
        currentRide = ride;
    }

    public void rateRide(Ride ride, int rate){
        for (int i=0;i<pastRides.size ();i++){
            if (pastRides.get (i).equals (ride)){
                pastRides.get (i).getAcceptedOffer ().getDriver ().getRating ().addRating (ride,rate);
            }
        }
    }

    public double getRating(String username){
        double avgRating=0;
        for (int i=0;i<pastRides.size ();i++){
            if(pastRides.get (i).getAcceptedOffer ().getDriver ().getUsername ().equals (username)){
                avgRating = pastRides.get (i).getAcceptedOffer ().getDriver ().getRating ().getAverageRating ();
            }
        }
        return avgRating;
    }

    public void checkOffers(Ride currentRide){
        System.out.println (currentRide.getOffers ());
    }

    public void acceptOffer(int offerNum){
        for (int i=0;i<currentRide.getOffers ().size ();i++){
            if (currentRide.getOffers ().get (i).equals (offerNum)){
                Offer accepted = currentRide.getOffers ().get (i);
                currentRide.setAcceptedOffer (accepted);
            }
        }

    }

    public void listPastRides(){
        for (int i=0;i<pastRides.size ();i++){
            System.out.println (pastRides.get (i));
        }

    }

    public Ride getPastRide(int index){
        return pastRides.get (index);
    }
}
