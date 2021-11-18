import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ride {
    private Area source;
    private Area destination;
    private Passenger passenger;
    private Offer acceptedOffer;
    private ArrayList<Offer> offers = new ArrayList<>();
    private Boolean isAccepted = false;

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public void viewOffers() {
        for(int i = 0; i < offers.size(); i++){
            System.out.println(i + "- " + offers.get(i));
        }
    }

    public void setOffer(int offerNumber) {
        acceptedOffer = offers.get(offerNumber);
    }

    public String toString(){
        return "Source: " + source.getLocation() + "/n" + "Destination: " + destination.getLocation() + "/nPassenger username: " +
                passenger.getUsername() + "/n Passenger phone number: " + passenger.getMobileNumber();
    }
}
