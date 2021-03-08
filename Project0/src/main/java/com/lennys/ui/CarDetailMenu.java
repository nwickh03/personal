package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;

import java.util.Scanner;

public class CarDetailMenu extends AbstractMenu {
    User activeUser;
    Car car;
    public CarDetailMenu(User activeUser, Car car) {

    }

    @Override
    public void showMenu(Scanner scan) {
        for (int i = 0; i < 3; i++) {



            System.out.println("***Car Detail Menu");
            System.out.println(car);
            System.out.println("1: Make offer");
            System.out.println("2: Return to lot menu");

            Integer answer = scan.nextInt();
            scan.nextLine();
            switch (answer){
                case 1: new MakeOfferMenu(activeUser,car).showMenu(scan);
                    break;
                case 2: new LotMenu(activeUser).showMenu(scan);
                    break;
                default:
            }


        }

    }
}
