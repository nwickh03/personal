package com.lennys.model.people;

import com.lennys.model.things.Car;
import com.lennys.model.things.UserType;

import java.security.InvalidParameterException;

public class User implements Comparable<User>{

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
        this.type = UserType.Customer;
    }
    public User(String username, String password, String phoneNumber, String email, int type) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        switch(type){
            case 0: this.type = UserType.Customer;
                break;
            case 1: this.type = UserType.Employee;
                break;
            case 2: this.type = UserType.Admin;
            break;
            default:throw new InvalidParameterException();


        }

    }


    @Override
    public int compareTo(User o) {
        return this.username.compareTo(o.getUsername());
    }
}
