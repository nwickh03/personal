package com.lennys.ui;

import com.lennys.model.people.User;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu{
    User activeUser;
    @Override
    public void showMenu(Scanner scan) {
        System.out.println("Welcome " + activeUser.getUsername());

       while(true) {


            System.out.println("Please select:");
            System.out.println("1: view lot");
            System.out.println("2: my cars");
            System.out.println("3: logout");
            Integer answer = scan.nextInt();
            scan.nextLine();
            switch (answer){
                case 1: new LotMenu(activeUser).showMenu(scan);
                    break;
                case 2: new PrivateLotMenu(activeUser).showMenu(scan);
                    break;
                case 3: return;
                default:
            }


        }
    }

    public CustomerMenu(User u) {
        activeUser = u;
    }
}
