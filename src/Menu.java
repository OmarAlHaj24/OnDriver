import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    DataManager manager = ListManager.getInstance();
    //Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("input.in"));
    Scanner sc = new Scanner(br);

    public Menu() throws FileNotFoundException {
    }

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
                    System.out.println("Please enter the username you would like to use (spaces not allowed): ");
                    String username = sc.next();
                    System.out.println("Please enter your mobile number: ");
                    String mobileNumber = sc.next();
                    System.out.println("Please enter your email: ");
                    String email = sc.next();
                    System.out.println("Please enter the password you would like to use: ");
                    String password = sc.next();
                    if (!IdentityManager.registerAsPassenger(new Passenger(username, mobileNumber, email, password))) {
                        System.out.println("Please choose a different username");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (input == 2) {
                System.out.println("=== Register as a driver ===");
                while (true) {
                    System.out.println("Please enter the username you would like to use (spaces not allowed): ");
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
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
        while (true) {
            System.out.println("=== Passenger menu ===");
            System.out.println("1- Request Ride");
            System.out.println("2- Rate Ride");
            System.out.println("3- Check Offers");
            System.out.println("4- Accept Offers");
            System.out.println("5- View Past Rides");
            System.out.println("6- Logout");
            int choice = sc.nextInt();
            if (choice == 6) {
                System.out.println("logged out");
                break;
            } else if (choice == 1) {
                System.out.println("Enter Source and Destination: ");
                String s = sc.next();
                Area source = manager.getArea(s);
                String d = sc.next();
                Area destination = manager.getArea(d);
                Ride ride = new Ride(source, destination, (Passenger) IdentityManager.currentUser);
                ((Passenger) IdentityManager.currentUser).requestRide(ride);
                System.out.println("Ride was successfully requested .. you can check your offers now");
            } else if (choice == 2) {
                System.out.println("Here is a list of all your past rides");
                if (((Passenger) IdentityManager.currentUser).listPastRides()) {
                    System.out.println("Enter the number of ride you would like to rate: ");
                    int ride = sc.nextInt();
                    while(true) {
                        System.out.println("Enter the rating: ");
                        int rating = sc.nextInt();
                        if (!((Passenger) IdentityManager.currentUser).rateRide(((Passenger) IdentityManager.currentUser).getPastRide(ride), rating)) {
                            System.out.println("You should enter a number between 1 and 5");
                            System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                            int input2 = sc.nextInt();
                            if (input2 == 1) {
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                } else {
                    System.out.println("You have no past rides to rate...");
                }
            } else if (choice == 3) {
                ((Passenger) IdentityManager.currentUser).checkOffers();
                System.out.println("1- If you would like to check the rating of a certain driver");
                System.out.println("2- Back");
                int input = sc.nextInt();
                if (input == 1) {
                    while (true) {
                        System.out.println("Enter the name of the driver whose rating you would like to view: ");
                        String name = sc.next();
                        double rating = ((Passenger) IdentityManager.currentUser).getRating(name);
                        if (rating == -1) {
                            System.out.println("Please enter the correct name of the driver: ");
                            System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                            int input2 = sc.nextInt();
                            if (input2 == 1) {
                                break;
                            }
                        } else {
                            System.out.println(rating);
                            break;
                        }
                    }
                }
            } else if (choice == 4) {
                while (true) {
                    ((Passenger) IdentityManager.currentUser).checkOffers();
                    System.out.println("Enter the number of offer you would like to accept or enter '-1' to go back: ");
                    int num = sc.nextInt();
                    if (num == -1) {
                        break;
                    }
                    if (!((Passenger) IdentityManager.currentUser).acceptOffer(num)) {
                        System.out.println("You entered a wrong number");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (choice == 5) {
                if (!((Passenger) IdentityManager.currentUser).listPastRides()) {
                    System.out.println("You have no past rides, try to ride more with us :)");
                }
            } else {
                System.out.println("Please choose a correct number");
            }
        }
    }

    public void driverMenu() {
        while (true) {
            System.out.println("=== Driver menu ===");
            System.out.println("1- Add Favorite Area");
            System.out.println("2- List all Rides within Favorite Area");
            System.out.println("3- Offer a Price to a Ride");
            System.out.println("4- List User's Rating");
            System.out.println("5- Log Out");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Please enter Name of the area: ");
                String name = sc.next();
                Area area = manager.getArea(name);
                ((Driver) IdentityManager.currentUser).addFavArea(area);
            } else if (choice == 2) {
                if (!((Driver) IdentityManager.currentUser).listFavouriteAreas()) {
                    continue;
                }
                System.out.println();

                while (true) {
                    System.out.print("Enter Number of Favorite Area: ");
                    int num = sc.nextInt();
                    if (!((Driver) IdentityManager.currentUser).viewRides(num)) {
                        System.out.println("You entered a wrong number");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    }else {
                        break;
                    }
                }
            } else if (choice == 3) {
                if (!((Driver) IdentityManager.currentUser).listFavouriteAreas()) {
                    continue;
                }
                System.out.println();
                int num = -1;
                while (true) {
                    System.out.print("Enter Number of Favorite Area: ");
                    num = sc.nextInt();
                    if (!((Driver) IdentityManager.currentUser).viewRides(num)) {
                        System.out.println("You entered a wrong number");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    }else {
                        break;
                    }
                }
                while (true) {
                    System.out.print("Enter Number of Ride you want to make an offer for: ");
                    int num1 = sc.nextInt();
                    if (!((Driver) IdentityManager.currentUser).isRideInArea(num1, num)) {
                        System.out.println("You entered a wrong number");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    }else {
                        System.out.print("Enter price to offer: ");
                        double price = sc.nextDouble();
                        Offer offer = new Offer(price, (Driver) IdentityManager.currentUser);
                        ((Driver) IdentityManager.currentUser).suggestOffer(num1, offer);
                        break;
                    }
                }

        } else if (choice == 4) {
            ((Driver) IdentityManager.currentUser).viewRating();
        } else if (choice == 5) {
            break;
        } else {
            System.out.println("You entered a wrong choice");
        }
        System.out.println();
    }
}

    public void adminMenu() {
        while (true) {
            System.out.println("=== Admin menu ===");
            System.out.println("1- Verify driver");
            System.out.println("2- Suspend user");
            System.out.println("3- Log out");
            int input = sc.nextInt();
            if (input == 1) {
                while (true) {
                    List<Driver> drivers = manager.listAllPendingDrivers();
                    for (int i = 0; i < drivers.size(); i++) {
                        System.out.println(drivers.get(i));
                    }
                    System.out.println("Please enter the username of the driver you would like to verify: ");
                    String username = sc.next();
                    if(!((Admin)IdentityManager.currentUser).verifyDriver(username)){
                        System.out.println("You entered a wrong username");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (input == 2) {
                while (true) {
                    System.out.println("Please enter the username of the driver you would like to suspend: ");
                    String username = sc.next();
                    if(!((Admin)IdentityManager.currentUser).suspend(username)){
                        System.out.println("You entered a wrong username");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
                    }else {
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