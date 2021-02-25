package com.lennys.ui;

import com.lennys.model.people.Employee;
import com.lennys.service.EmployeeService;

import java.util.Scanner;

public class EmployeeLoginMenu extends AbstractMenu {

    public void showMenu(Scanner scan) {


        for (int i = 0; i <= 2; i++) {
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();
            Employee e = (Employee) new EmployeeService().findUserByUsername(username);
            if (e == null || !e.getPassword().equals(password)) {
                System.out.println("login failed");
            } else {
                System.out.println("success");
                break;

            }
        }
    }
}

