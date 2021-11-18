import java.util.ArrayList;

public interface AreaSubject {
    ArrayList<Driver> drivers = new ArrayList<Driver>();

    public void subscribe(Driver driver);

    public void unsubscribe(Driver driver);

    public void notifyDrivers();
}
