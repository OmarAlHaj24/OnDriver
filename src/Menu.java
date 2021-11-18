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
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Passenger Menu: ");
            System.out.println("1- Logout");
            System.out.println("2- Request Ride");
            System.out.println("3- Rate Ride");
            System.out.println("4- Check Offers");
            System.out.println("5- Accept Offers");
            System.out.println("6- View Past Rides");
            System.out.println("--Please enter the number of your choice--");
            choice = sc.nextInt();

            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println("Enter Source and Destination: ");
                String s = sc.nextLine();
                Area source = new Area(s);
                String d = sc.nextLine();
                Area destination = new Area(d);
                Ride ride = new Ride(source, destination, (Passenger) IdentityManager.currentUser);
                ((Passenger) IdentityManager.currentUser).requestRide(ride);
                System.out.println("Ride was successfully requested .. you can check your offers now");
            } else if (choice == 3) {
                System.out.println("There's List of all past rides");
                ((Passenger) IdentityManager.currentUser).getPastRides();
                System.out.println("Enter the number of ride you wanna rate: ");
                int ride = sc.nextInt();
                System.out.println("Enter the rating: ");
                int rating = sc.nextInt();
                ((Passenger) IdentityManager.currentUser).rateRide(((Passenger) IdentityManager.currentUser).getPastRide(ride), rating);
            } else if (choice == 4) {
                ((Passenger) IdentityManager.currentUser).checkOffers();
                boolean end = true;
                while (end) {
                    System.out.println("Enter the name of driver you wanna view its average rating:");
                    String name = sc.next();
                    ((Passenger) IdentityManager.currentUser).getRating(name);
                    if (name.isEmpty()) end = false;
                }
            } else if (choice == 5) {
                ((Passenger) IdentityManager.currentUser).checkOffers();
                System.out.println("Enter the number of offer you wanna accept: ");
                int num = sc.nextInt();
                ((Passenger) IdentityManager.currentUser).acceptOffer(num);
            } else if (choice == 6) {
                ((Passenger) IdentityManager.currentUser).getPastRides();
            } else {
                System.out.println("Wrong, Please enter right number");
            }
        }
    }

    public void driverMenu() {
        while (true) {
            System.out.println("1- Add Favorite Area");
            System.out.println("2- List all Rides within Favorite Area");
            System.out.println("3- Offer a Price to a Ride");
            System.out.println("4- List User's Rating");
            System.out.println("5- Log Out");
            System.out.print("Your Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Name of the area: ");
                String name = sc.nextLine();
                Area area = manager.getArea(name);
                if (area == null) {
                    area = new Area(name);
                    manager.addToArea(area);
                }
                ((Driver) IdentityManager.currentUser).addFavArea(area);
            } else if (choice == 2) {
                ((Driver) IdentityManager.currentUser).listFavouriteAreas();
                System.out.println();
                System.out.print("Enter Number of Favorite Area: ");
                while (true) {
                    int num = sc.nextInt();
                    if (num >= ((Driver) IdentityManager.currentUser).getFavouriteAreas().size()) {
                        System.out.println("You entered a wrong number");
                        System.out.println("Enter Number of Favorite Area: ");
                        continue;
                    }
                    ((Driver) IdentityManager.currentUser).viewRides(num);
                    break;
                }
            } else if (choice == 3) {
                ((Driver) IdentityManager.currentUser).listFavouriteAreas();
                System.out.println();
                System.out.print("Enter Number of Favorite Area: ");
                while (true) {
                    int num = sc.nextInt();
                    if (num >= ((Driver) IdentityManager.currentUser).getFavouriteAreas().size()) {
                        System.out.println("You entered a wrong number");
                        System.out.println("Enter Number of Favorite Area: ");
                        continue;
                    }
                    ((Driver) IdentityManager.currentUser).viewRides(num);
                    System.out.print("Enter Number of Ride: ");
                    Ride ride;
                    while (true) {
                        int num1 = sc.nextInt();
                        if (num1 >= ((Driver) IdentityManager.currentUser).getRides().size()) {
                            System.out.println("You entered a wrong number");
                            System.out.println("Enter Number of Ride: ");
                            continue;
                        }
                        if (!((Driver) IdentityManager.currentUser).isRideInArea(num1, num)) {
                            System.out.println("You entered a wrong number");
                            System.out.println("Enter Number of Ride: ");
                            continue;
                        }
                        System.out.print("Enter price to offer: ");
                        Double price = sc.nextDouble();
                        Offer offer = new Offer(price, (Driver) IdentityManager.currentUser);
                        ((Driver) IdentityManager.currentUser).suggestOffer(num1, offer);
                        break;
                    }

                    break;
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
                    Driver tempDriver = manager.getDriver(username);
                    if (tempDriver == null) {
                        System.out.println("Please enter a valid driver username");
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
                        System.out.println("If you want to go back enter: 1\nIf you want to continue enter: 2");
                        int input2 = sc.nextInt();
                        if (input2 == 1) {
                            break;
                        }
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
