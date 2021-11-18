import java.util.ArrayList;
import java.util.List;

public class Passenger extends User{
    private ArrayList<Ride>pastRides;
    private Ride currentRide;
    private Passenger(){
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
                pastRides.get (i)
            }
        }
    }

    public double getRating(String username){

        return 0;
    }

    public void checkOffers(Ride currentRide){

    }

    public void acceptOffer(int offerNum){

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
