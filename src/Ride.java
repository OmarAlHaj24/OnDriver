import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ride {
    private Area source;
    private Area destination;
    private Passenger passenger;
    private Offer acceptedOffer;
    private ArrayList<Offer> offers = new ArrayList<>();
    private Boolean isAccepted = false;

    public Ride(Area source, Area destination, Passenger passenger) {
        this.source = source;
        this.passenger = passenger;
        this.destination = destination;
        acceptedOffer = null;
    }

    public void setSource(Area source) {
        this.source = source;
    }

    public Area getSource() {
        return source;
    }

    public void setDestination(Area destination) {
        this.destination = destination;
    }

    public Area getDestination() {
        return destination;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setAcceptedOffer(Offer acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
    }

    public Offer getAcceptedOffer() {
        return acceptedOffer;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public void viewOffers() {
        for (int i = 0; i < offers.size(); i++) {
            System.out.println(i + "- " + offers.get(i));
        }
    }

    public void setOffer(int offerNumber) {
        acceptedOffer = offers.get(offerNumber);
    }

    public String toString() {
        return "Source: " + source.getLocation() + "\n" + "Destination: " + destination.getLocation() + "\nPassenger username: " +
                passenger.getUsername() + "\n Passenger phone number: " + passenger.getMobileNumber();
    }
}
