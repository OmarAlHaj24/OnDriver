import java.util.List;

public class Driver implements DriverObserver{
    private String driverLicense;
    private String nationalID;
    private Boolean isVerified = false;
    private List<Area>favouriteAreas;
    private List<Ride> rides;
    private Rating rating;

    public void setDriverLicense(String driverLicense) {
        this.driverLicense=driverLicense;
    }
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setNationalID(String nationalID) {
        this.nationalID=nationalID;
    }
    public String getNationalID() {
        return nationalID;
    }

    public void setVerified(Boolean verified) {
        isVerified=verified;
    }
    public Boolean getVerified() {
        return isVerified;
    }

    public void setFavouriteAreas(List<Area> favouriteAreas) {
        this.favouriteAreas=favouriteAreas;
    }
    public List<Area> getFavouriteAreas() {
        return favouriteAreas;
    }

    public void setRides(List<Ride> rides) {
        this.rides=rides;
    }
    public List<Ride> getRides() {
        return rides;
    }

    public void setRating(Rating rating) {
        this.rating=rating;
    }
    public Rating getRating() {
        return rating;
    }

    public void suggestOffer(Ride ride){

    }

    public void viewRides(int index){

    }

    public void viewRating(){

    }

    public void addFavArea(Area area){

    }

    public void listFavouriteAreas(){

    }


}
