package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.service.UserService;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu {
    public void showMenu(Scanner scan) {

        for (int i = 0; i <= 2; i++) {
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();
            User u = UserService.getInstance().findUserByUsername(username);
            if (u == null || !u.getPassword().equals(password)) {
                System.out.println("login failed");
            } else {
                System.out.println("success");
                switch (u.getType()){
                    case Customer: new CustomerMenu(u).showMenu(scan);
                    return;
                    case Employee: new EmployeeMenu(u).showMenu(scan);
                    return;
                    case Admin:
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + u.getType());
                }


            }
        }
    }

}