import java.util.List;

public class IdentityManager {
    public static User currentUser;
    private static DataManager manager = ListManager.getInstance();;

    public static Boolean registerAsPassenger(Passenger user){
        if(manager.isAvailable(user.username)){
            manager.addToPassenger(user);
            return true;
        }else{
            return false;
        }
    }

    public static Boolean registerAsDriver(Driver user){
        if(manager.isAvailable(user.username)){
            manager.addToDriver(user);
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsPassenger(String username, String password){
        Passenger tempPassenger = manager.getPassenger(username);
        if(tempPassenger.password.equals(password)){
            currentUser = tempPassenger;
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsDriver(String username, String password){
        Driver tempDriver = manager.getDriver(username);
        if(tempDriver.password.equals(password)){
            currentUser = tempDriver;
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsAdmin(String username, String password){

    }
}
