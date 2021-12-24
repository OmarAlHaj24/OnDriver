package com.API.OnDriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnDriverApplication {

    public static void main(String[] args) {
        ListManager manager = ListManager.getInstance();
        Admin admin = new Admin("admin", "010", "admin@gmail.com", "admin");
        manager.addToAdmin(admin);
        SpringApplication.run(OnDriverApplication.class, args);
    }

}
