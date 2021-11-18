import java.util.List;

public interface DataManager {
    public Boolean isAvailable(String userName);

    public List<Driver> listAllPendingDrivers();

    public User getUser(String userName);

    public Boolean addToPassenger(Passenger passenger);

    public Passenger getPassenger(String userName);

    public Boolean addToDriver(Driver driver);

    public Driver getDriver(String userName);

    public Boolean addToArea(Area area);

    public Area getArea(String location);

    public Boolean addToAdmin(Admin admin);

    public Admin getAdmin(String username);
}
