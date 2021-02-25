package com.lennys.ui;

import com.lennys.model.people.User;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu{
    User activeUser;
    @Override
    public void showMenu(Scanner scan) {
        System.out.println("Welcome " + activeUser);
        System.out.println("Enter 1 to view available cars");
        System.out.println("Enter 1 to view available cars");

    }

    public CustomerMenu(User u) {
        activeUser = u;
    }
}
