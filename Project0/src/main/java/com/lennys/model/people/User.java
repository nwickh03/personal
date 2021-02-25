package com.lennys.model.people;

import com.lennys.model.things.Car;
import com.lennys.model.things.UserType;

public class User {

    private String username;
    private String password;
    private Car[] carsOwned;
    private String phoneNumber;
    private String email;
    private UserType type;

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Car[] getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(Car[] carsOwned) {
        this.carsOwned = carsOwned;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
