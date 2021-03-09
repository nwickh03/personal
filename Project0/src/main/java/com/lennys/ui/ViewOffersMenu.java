package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.model.things.Offer;
import com.lennys.service.LotService;
import com.lennys.util.LennyLinkedTreeSet;

import java.util.Scanner;

public class ViewOffersMenu extends AbstractMenu{
    User activeUser;
    Car car;
    public ViewOffersMenu(User activeUser, Car car) {
        this.activeUser = activeUser;
        this.car = car;
    }

    @Override
    public void showMenu(Scanner scan) {
        LennyLinkedTreeSet<Offer> offers = LotService.getInstance().viewOffers(car);
        System.out.println("**Offers");
        for (Offer o : offers) { System.out.println(o);}
        System.out.println("Enter offer id to select offer");
        Offer answer = offers.getByIntKey(scan.nextInt());
        scan.nextLine();
        if(null != answer){
            System.out.println("1 to accept offer");
            System.out.println("2 to reject offer");
            int a2 = scan.nextInt();
            scan.nextLine();
            switch (a2){
                case 1: LotService.getInstance().acceptOffer(answer);
                break;
                case 2: LotService.getInstance().rejectOffer(answer);
                break;
                default:
                    System.out.println("input failure");
            }
        }




    }
}
