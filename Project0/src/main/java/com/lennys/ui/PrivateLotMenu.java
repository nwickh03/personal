package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.service.LotService;
import com.lennys.util.LennyLinkedTreeSet;

import java.util.Scanner;

public class PrivateLotMenu extends AbstractMenu {
    User activeUser;
    LennyLinkedTreeSet<Car>  userLot;
    public PrivateLotMenu(User activeUser) {
        this.activeUser = activeUser;
        userLot = LotService.getInstance().viewUserLot(activeUser.getUsername());
    }

    @Override
    public void showMenu(Scanner scan) {
        System.out.println("*** " + activeUser.getUsername() + "'s cars" );
        if(userLot.isEmpty()){
            System.out.println("you have no cars");
        }else
        for (Car c : userLot) {System.out.println(c.toStringWithPayment());}



    }
}
