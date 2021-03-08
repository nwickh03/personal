package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;

import java.util.Scanner;

public class MakeOfferMenu extends AbstractMenu {
    User activeUser;
    Car car;

    public MakeOfferMenu(User activeUser, Car car) {
        this.activeUser = activeUser;
        this.car = car;
    }
    @Override
    public void showMenu(Scanner scan) {

        for (int i = 0; i < 3; i++) {



            System.out.println("***Employee Menu");
            System.out.println("Please select:");
            System.out.println("1: view lot");
            System.out.println("2: view payments");
            System.out.println("3: add car");
            System.out.println("4: remove car");
            Integer answer = scan.nextInt();
            scan.nextLine();
            switch (answer){
                case 1: new LotMenu(activeUser).showMenu(scan);
                    break;
                case 2: new PaymentMenu(activeUser).showMenu(scan);
                    break;
                case 3: new AddCarMenu().showMenu(scan);
                    break;
                case 4: new RemoveCarMenu().showMenu(scan);
            }


        }
    }


}
