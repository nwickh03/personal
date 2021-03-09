package com.lennys.ui;

import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.service.LotService;
import com.lennys.util.LennyLinkedTreeSet;

import java.util.Scanner;

public class EmpPaymentMenu extends AbstractMenu {
    User activeUser;
    public EmpPaymentMenu(User activeUser) {
        this.activeUser = activeUser;
    }

    @Override
    public void showMenu(Scanner scan) {
       LennyLinkedTreeSet<Car> offLot = LotService.getInstance().viewOffLot();
        for (Car c: offLot) {
            System.out.println(c.toStringWithPayment());
        };
        String pause = scan.nextLine();

    }
}
