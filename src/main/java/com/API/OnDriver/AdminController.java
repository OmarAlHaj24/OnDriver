package com.API.OnDriver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminController {
    public Admin currentUser;

    @PostMapping("/admin/verify/{username}")
    public String verifyDriver(@PathVariable String username) {
        currentUser = IdentityManager.currentAdmin;
        if (IdentityManager.currentAdmin == null) {
            return "You have no access to this function";
        }
        if (currentUser.verifyDriver(username)) {
            return "User verified successfully";
        } else {
            return "User could not be found";
        }
    }

    @PostMapping("/admin/suspend/{username}")
    public String suspend(@PathVariable String username) {
        currentUser = IdentityManager.currentAdmin;
        if (IdentityManager.currentAdmin == null) {
            return "You have no access to this function";
        }
        if (currentUser.suspend(username)) {
            IdentityManager.logout(username);
            return "User suspended successfully";
        } else {
            return "User could not be found";
        }
    }

    @PostMapping("/admin/getSystemRides")
    public ArrayList<String> getSystemRides() {
        currentUser = IdentityManager.currentAdmin;
        if (IdentityManager.currentAdmin == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You have no access to this function");
            return temp;
        }
        return currentUser.getSystemRides();
    }

    @PostMapping("/admin/getSystemRides/{idx}")
    public ArrayList<String> getRideEvents(@PathVariable int idx) {
        currentUser = IdentityManager.currentAdmin;
        if (IdentityManager.currentAdmin == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("You have no access to this function");
            return temp;
        }
        return currentUser.getRideEvents(idx);
    }
}
