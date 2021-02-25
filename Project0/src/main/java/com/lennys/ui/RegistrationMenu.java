package com.lennys.ui;

import com.lennys.service.UserService;

import java.util.Scanner;

public class RegistrationMenu extends AbstractMenu{

    public void NewCustomerMenu() {
        Scanner scan = new Scanner(System.in);

        UserService us = new UserService();
        System.out.println("***New User Registration");
        String username = "";
        // hey something is wrong
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            if(us.doesUsernameExist(username)){
                System.out.println("username already in use");
                continue;
            }else break;
        } while(true);
        System.out.println("provide password");
        // TODO: check phone number
        String password = scan.nextLine();
        System.out.println("provide phone number");
        // TODO: check email
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println(us.makeUser(username, password, phoneNumber, email) ?
                "successfully made "+username :
                "cancelled registration");
    }

    @Override
    public void showMenu(Scanner scan) {

        UserService us = new UserService();
        System.out.println("***New User Registration");
        String username = "";
        // hey something is wrong
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            if(us.doesUsernameExist(username)){
                System.out.println("username already in use");
                continue;
            }else break;
        } while(true);
        System.out.println("provide password");
        // TODO: check phone number
        String password = scan.nextLine();
        System.out.println("provide phone number");
        // TODO: check email
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println(us.makeUser(username, password, phoneNumber, email) ?
                "successfully made "+username :
                "cancelled registration");

    }
}
