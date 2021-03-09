package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;

import java.util.*;

public class CarDetailMenu extends AbstractMenu {
    User activeUser;
    Car car;
    public CarDetailMenu(User activeUser, Car car) {
            this.activeUser = activeUser;
            this.car = car;

    }

    @Override
    public void showMenu(Scanner scan) {
        switch (activeUser.getType()) {
            case Customer:
                customer(scan);
                break;
            case Employee:
                employee(scan);
                break;
            case Admin:
                break;
        }
    }

    private void employee(Scanner scan) {
        for (int i = 0; i < 3; i++) {


            try {
                System.out.println("***Car Detail Menu");
                System.out.println(car);
                System.out.println("1: View offers");
                System.out.println("2: Return to previous menu");

                int answer = scan.nextInt();
                scan.nextLine();
                switch (answer){
                    case 1: new ViewOffersMenu(activeUser,car).showMenu(scan);
                        return;
                    case 2: return;
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("input failed");
            }

        }
    }



    private void customer(Scanner scan) {
        for (int i = 0; i < 3; i++) {


            try {
                System.out.println("***Car Detail Menu");
                System.out.println(car.toStringSimple());
                System.out.println("1: Make offer");
                System.out.println("2: Return to previous menu");

                int answer = scan.nextInt();
                scan.nextLine();
                switch (answer){
                    case 1: new MakeOfferMenu(activeUser,car).showMenu(scan);
                        return;
                    case 2: return;
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("input failed");
            }

        }
    }
}
