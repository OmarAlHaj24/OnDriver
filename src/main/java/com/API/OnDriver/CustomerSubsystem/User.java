package com.API.OnDriver.CustomerSubsystem;

public abstract class User {
    private String username;
    private String mobileNumber;
    private String email;
    private String password;
    private UserStatus userStatus;

    public User(String username, String mobileNumber, String email, String password, UserStatus userStatus) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = email;
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }


    public String toString() {
        return "Username: " + getUsername() + " || " + "Mobile Number: " + getMobileNumber() + " || " + "Email: " + getEmail() +
                " || " + "User Status: " + getUserStatus() + " || ";
    }
}
