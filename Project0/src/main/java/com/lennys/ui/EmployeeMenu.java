package com.lennys.ui;

import com.lennys.model.people.User;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu{
    User activeUser;

    @Override
    public void showMenu(Scanner scan) {

        boolean inMenu = true;
       while(inMenu) {



            System.out.println("***Employee Menu");
            System.out.println("Please select:");
            System.out.println("1: view lot");
            System.out.println("2: view payments");
            System.out.println("3: add car");
            System.out.println("4: remove car");
           System.out.println("5: logout");
            int answer = scan.nextInt();
            scan.nextLine();
            switch (answer){
                case 1: new LotMenu(activeUser).showMenu(scan);
                break;
                case 2: new EmpPaymentMenu(activeUser).showMenu(scan);
                break;
                case 3: new AddCarMenu().showMenu(scan);
                break;
                case 4: new RemoveCarMenu().showMenu(scan);
                break;
                case 5: return;
                default:
            }


        }
    }

    public EmployeeMenu(User u) {
        activeUser = u;
    }

}
