package com.lennys.ui;

import com.lennys.model.people.User;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu{
    User activeUser;
    @Override
    public void showMenu(Scanner scan) {
        System.out.println("Welcome " + activeUser.getUsername());
        for (int i = 0; i < 3; i++) {


            System.out.println("Please select:");
            System.out.println("1: view lot");
            System.out.println("2: my cars");
            Integer answer = scan.nextInt();
            scan.nextLine();
            switch (answer){
                case 1: new LotMenu(activeUser).showMenu(scan);
                    break;
                case 2: new PaymentMenu(activeUser).showMenu(scan);
                    break;
                default:
            }


        }
    }

    public CustomerMenu(User u) {
        activeUser = u;
    }
}
