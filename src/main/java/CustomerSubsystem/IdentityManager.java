package CustomerSubsystem;

import DataSubsystem.DataManager;
import DataSubsystem.ListManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IdentityManager {
    public static Admin currentAdmin;
    private static final DataManager manager = ListManager.getInstance();
    private static ArrayList<Driver> loggedInDrivers = new ArrayList<>();
    private static ArrayList<Passenger> loggedInPassengers = new ArrayList<>();

    @PostMapping("/register/passenger")
    public static String registerAsPassenger(@RequestBody Passenger user) {
        if (manager.isAvailable(user.getUsername())) {
            manager.addToPassenger(user);
            return "Registered successfully";
        } else {
            return "The username you entered is unavailable";
        }
    }

    @PostMapping("/register/driver")
    public static String registerAsDriver(@RequestBody Driver user) {
        if (manager.isAvailable(user.getUsername())) {
            manager.addToDriver(user);
            return "Registered successfully";
        } else {
            return "The username you entered is unavailable";
        }
    }

    @PostMapping("/login/passenger/{username}/{password}")
    public static String loginAsPassenger(@PathVariable String username, @PathVariable String password) {
        Passenger tempPassenger = manager.getPassenger(username);
        if (tempPassenger == null) {
            return "The username you entered is not registered";
        }
        if (tempPassenger.getUserStatus() == UserStatus.suspended) {
            return "This account is currently suspended, Please contact the admin";
        }
        if (tempPassenger.getPassword().equals(password)) {
            if (loggedInPassengers.contains(tempPassenger)) {
                return "User already logged in";
            }
            loggedInPassengers.add(tempPassenger);
            return "Logged in successfully";
        } else {
            return "You entered a wrong password";
        }
    }

    @PostMapping("/login/driver/{username}/{password}")
    public static String loginAsDriver(@PathVariable String username, @PathVariable String password) {
        Driver tempDriver = manager.getDriver(username);
        if (tempDriver == null) {
            return "The username you entered is not registered";
        }
        if (tempDriver.getUserStatus() == UserStatus.suspended || !tempDriver.getVerified()) {
            return "This account is currently suspended or not verified yet, Please contact the admin";
        }
        if (tempDriver.getPassword().equals(password)) {
            if (loggedInDrivers.contains(tempDriver)) {
                return "User already logged in";
            }
            loggedInDrivers.add(tempDriver);
            return "Logged in successfully";
        } else {
            return "You entered a wrong password";
        }
    }

    @PostMapping("/login/admin/{username}/{password}")
    public static String loginAsAdmin(@PathVariable String username, @PathVariable String password) {
        Admin tempAdmin = manager.getAdmin(username);
        if (tempAdmin == null) {
            return "The username you entered is not registered";
        }
        if (tempAdmin.getPassword().equals(password) && currentAdmin == null) {
            currentAdmin = tempAdmin;
            return "Logged in successfully";
        } else if (currentAdmin != null) {
            return "User already logged in";
        } else {
            return "You entered a wrong password";
        }
    }

    @PostMapping("/logout/{username}")
    public static String logout(@PathVariable String username) {
        if (currentAdmin.getUsername().equals(username)) {
            currentAdmin = null;
            return "Logged out successfully";
        }

        for (int i = 0; i < loggedInDrivers.size(); i++) {
            if (loggedInDrivers.get(i).getUsername().equals(username)) {
                loggedInDrivers.remove(loggedInDrivers.get(i));
                return "Logged out successfully";
            }
        }

        for (int i = 0; i < loggedInPassengers.size(); i++) {
            if (loggedInPassengers.get(i).getUsername().equals(username)) {
                loggedInPassengers.remove(loggedInPassengers.get(i));
                return "Logged out successfully";
            }
        }

        return "You are not logged in";
    }

    public static Passenger getPassenger(String username) {
        for (int i = 0; i < loggedInPassengers.size(); i++) {
            if (loggedInPassengers.get(i).getUsername().equals(username)) {
                return loggedInPassengers.get(i);
            }
        }
        return null;
    }

    public static Driver getDriver(String username) {
        for (int i = 0; i < loggedInDrivers.size(); i++) {
            if (loggedInDrivers.get(i).getUsername().equals(username)) {
                return loggedInDrivers.get(i);
            }
        }
        return null;
    }
}
