# OnDriver
**This project is a RESTFUL API implemented using Java and Springboot, It provides a car booking service.**

## The system is divided into four parts.
* ### Customer subsystem
    This subsystem contains most of the classes upon which any of the system users (Passengers, Drivers, Admins) depend in order for them to get their needs done.
* ### Data subsystem
    This subsystem contains all the classes that has to do with saving or manipulating any of our system's data. This system depends on arraylists to save the data, But a database management system can be used at any time interchangebly with these arraylists.
* ### Event subsystem
    This subsystem contains the classes responsible for tracking all the events that take place within the system.
* ### Ride subsystem
    This subsystem contains the classes that are responsible for the ride management and the driver's offers.

## The following is the system documentation
* ### Note that the system contains four REST controllers.

## Identity Management Functions:
* ### 1 - Register as passenger:http://localhost:8080/register/passenger + The data of the passenger should be passed in an XML or a Json format.
* ### 2 - Register as driver: http://localhost:8080/register/driver + The data of the driver should be passed in an XML or a Json format.
* ### 3 - Login as passenger: http://localhost:8080/login/passenger/{Username}/{Password}.
* ### 4 - Login as driver: http://localhost:8080/login/driver/{Username}/{Password} (Driver needs to be verified by an admin before he can log in).
* ### 5 - Login as admin: http://localhost:8080/login/admin/{Username}/{Password}.
* ### 6 - Logout: http://localhost:8080/logout/{Username}

## Admin Functions:
* ### 1 - Verify driver: http://localhost:8080/admin/verify/{DriverName}.
* ### 2 - Suspend user: http://localhost:8080/admin/suspend/{UserName}.
* ### 3 - Get all system rides: http://localhost:8080/admin/getSystemRides.
* ### 4 - Get the events of a ride: http://localhost:8080/admin/getRideEvents/{idx}.
    You can get the idx of the ride by first calling function number 3.
* ### 5 - Apply discount on rides headed to a certain area: http://localhost:8080/admin/applyDiscount/{areaName}.

## Driver Functions:
* ### 1 - Add Favourite Area: http://localhost:8080/driver/addFavouriteArea/{currentUsername}/{areaName}
* ### 2 - List Favourite Areas: http://localhost:8080/driver/ListFavouriteArea/{currentUsername}
* ### 3 - View Rides of an Area: http://localhost:8080/driver/viewRides/{currentUsername}/{areaNum}
* ### 4 - Suggest an offer to a ride: http://localhost:8080/driver/suggestOffer/{currentUsername}/{rideNum}/{offerPrice}
* ### 5 - View user's rating: http://localhost:8080/driver/viewRating/{currentUsername}
* ### 6 - Start ride: http://localhost:8080/driver/startRide/{currentUsername}
* ### 7 - End ride: http://localhost:8080/driver/endRide/{currentUsername}

## Passenger Functions:
* ### 1 - Passenger requests ride: http://localhost:8080/passenger/request/{currentUsername}/{source}/{destination}/{numberOfPassengers}
* ### 2 - Passenger views past rides: http://localhost:8080/passenger/viewPastRides/{currentUsername}
* ### 3 - Passenger rate ride: http://localhost:8080/passenger/rateRide/{currentUsername}/{rideIdx}/{rate}
* ### 4 - Passenger checks offers: http://localhost:8080/passenger/viewOffers/{currentUsername}
* ### 5 - Passenger accepts offers: http://localhost:8080/passenger/acceptOffers/{currentUsername}/{offerNum}
