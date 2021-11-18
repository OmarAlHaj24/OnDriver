import java.util.List;

public class IdentityManager {
    public static User currentUser;
    private static final DataManager manager = ListManager.getInstance();;

    public static Boolean registerAsPassenger(Passenger user){
        if(manager.isAvailable(user.getUsername())){
            manager.addToPassenger(user);
            return true;
        }else{
            return false;
        }
    }

    public static Boolean registerAsDriver(Driver user){
        if(manager.isAvailable(user.getUsername())){
            manager.addToDriver(user);
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsPassenger(String username, String password){
        Passenger tempPassenger = manager.getPassenger(username);
        if(tempPassenger == null){
            return false;
        }
        if(tempPassenger.getPassword().equals(password)){
            currentUser = tempPassenger;
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsDriver(String username, String password){
        Driver tempDriver = manager.getDriver(username);
        if(tempDriver == null){
            return false;
        }
        if(tempDriver.getPassword().equals(password)){
            currentUser = tempDriver;
            return true;
        }else{
            return false;
        }
    }

    public static Boolean loginAsAdmin(String username, String password){
        Admin tempAdmin = manager.getAdmin(username);
        if(tempAdmin == null){
            return false;
        }
        if(tempAdmin.getPassword().equals(password)){
            currentUser = tempAdmin;
            return true;
        }else{
            return false;
        }
    }
}
