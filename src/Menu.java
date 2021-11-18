import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    DataManager manager = ListManager.getInstance();
    Scanner sc = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            System.out.println("=== Welcome to OnDriver ===");
            System.out.println("1- Register as a passenger");
            System.out.println("2- Register as a driver");
            System.out.println("3- Log in as a passenger");
            System.out.println("4- Log in as a driver");
            System.out.println("5- Log in as an admin");
            System.out.println("6- Exit");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.println("=== Register as a passenger ===");
                while (true) {
                    System.out.println("Please enter the username you would like to use: ");
                    String username = sc.next();
                    System.out.println("Please enter your mobile number: ");
                    String mobileNumber = sc.next();
                    System.out.println("Please enter your email: ");
                    String email = sc.next();
                    System.out.println("Please enter the password you would like to use: ");
                    String password = sc.next();
                    if (!IdentityManager.registerAsPassenger(new Passenger(username, mobileNumber, email, password))) {
                        System.out.println("Please choose a different username");
                    } else {
                        break;
                    }
                }
            } else if (input == 2) {
                System.out.println("=== Register as a driver ===");
                while (true) {
                    System.out.println("Please enter the username you would like to use: ");
                    String username = sc.next();
                    System.out.println("Please enter your mobile number: ");
                    String mobileNumber = sc.next();
                    System.out.println("Please enter your email: ");
                    String email = sc.next();
                    System.out.println("Please enter the password you would like to use: ");
                    String password = sc.next();
                    System.out.println("Please enter your license number: ");
                    String license = sc.next();
                    System.out.println("Please enter your ID number: ");
                    String id = sc.next();
                    if (!IdentityManager.registerAsDriver(new Driver(username, mobileNumber, email, password, license, id))) {
                        System.out.println("Please choose a different username");
                    } else {
                        break;
                    }
                }
            } else if (input == 3) {
                System.out.println("=== Log in as a passenger");
                while (true) {
                    System.out.println("Please enter your username: ");
                    String username = sc.next();
                    System.out.println("Please enter your password: ");
                    String password = sc.next();
                    if (IdentityManager.loginAsPassenger(username, password)) {
                        passengerMenu();
                        break;
                    } else {
                        System.out.println("You either entered wrong credentials or your account is suspended");
                    }
                }
            } else if (input == 4) {
                System.out.println("=== Log in as a driver");
                while (true) {
                    System.out.println("Please enter your username: ");
                    String username = sc.next();
                    System.out.println("Please enter your password: ");
                    String password = sc.next();
                    if (IdentityManager.loginAsDriver(username, password)) {
                        driverMenu();
                        break;
                    } else {
                        System.out.println("You either entered wrong credentials or your account is suspended or not verified yet");
                    }
                }
            } else if (input == 5) {
                System.out.println("=== Log in as an admin");
                while (true) {
                    System.out.println("Please enter your username: ");
                    String username = sc.next();
                    System.out.println("Please enter your password: ");
                    String password = sc.next();
                    if (IdentityManager.loginAsAdmin(username, password)) {
                        adminMenu();
                        break;
                    } else {
                        System.out.println("You either entered wrong credentials or your account is suspended");
                    }
                }
            } else if (input == 6) {
                break;
            } else {
                System.out.println("Please choose a correct number");
            }
        }
    }

    public void passengerMenu() {
        System.out.println("YOU ARE NOW A PASSENGER");
    }

    public void driverMenu() {
        System.out.println("YOU ARE NOW A DRIVER");
    }

    public void adminMenu() {
        System.out.println("=== Admin menu ===");
        System.out.println("1- Verify driver");
        System.out.println("2- Suspend user");
        System.out.println("3- Log out");
        int input = sc.nextInt();
        while (true) {
            if (input == 1) {
                while (true) {
                    List<Driver> drivers = manager.listAllPendingDrivers();
                    for (int i = 0; i < drivers.size(); i++) {
                        System.out.println(drivers.get(i));
                    }
                    System.out.println("Please enter the username of the driver you would like to verify: ");
                    String username = sc.next();
                    Driver tempDriver = manager.getDriver(username);
                    if (tempDriver == null) {
                        System.out.println("Please enter a valid driver username");
                    } else {
                        tempDriver.setVerified(true);
                        break;
                    }
                }
            } else if (input == 2) {
                while (true) {
                    System.out.println("Please enter the username of the user you would like to suspend: ");
                    String username = sc.next();
                    User tempUser = manager.getUser(username);
                    if (tempUser == null) {
                        System.out.println("Please enter a valid username");
                    } else {
                        tempUser.setUserStatus(UserStatus.suspended);
                        break;
                    }
                }
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Please choose a correct number");
            }
        }
    }
}
