package com.API.OnDriver;

public class Admin extends User {
    public Admin(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password, UserStatus.admin);
    }

    ListManager manager = ListManager.getInstance();

    public boolean verifyDriver(String username) {
        Driver tempDriver = manager.getDriver(username);
        if(tempDriver == null){
            return false;
        }else{
            tempDriver.setVerified(true);
            return true;
        }
    }

    public Boolean suspend(String username) {
        User user = manager.getUser(username);
        if (user == null) {
            return false;
        }else{
            user.setUserStatus(UserStatus.suspended);
            return true;
        }
    }
}
