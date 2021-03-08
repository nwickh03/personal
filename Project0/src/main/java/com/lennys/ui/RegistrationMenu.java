package com.lennys.ui;

import com.lennys.exception.DBException;
import com.lennys.exception.DuplicateEntryException;
import com.lennys.service.UserService;

import java.util.Scanner;

public class RegistrationMenu extends AbstractMenu{

    @Override
    public void showMenu(Scanner scan) {

        System.out.println("***New User Registration");
        String username = "";
        // hey something is wrong
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            if(UserService.getInstance().doesUsernameExist(username)){
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
        try{
            UserService.getInstance().register(username, password, phoneNumber, email);
            System.out.println("successfully made " + username);
        } catch (DBException | DuplicateEntryException e) {
            System.out.println("registration failed");
        }

    }
}
