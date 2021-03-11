package com.lennys.ui;

import com.lennys.exception.DBException;
import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.service.LotService;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LotMenu extends AbstractMenu {
    User activeUser;
    LennyLinkedTreeSet<Car> activeLot;

    public LotMenu(User activeUser) { this.activeUser = activeUser;    }

    @Override
    public void showMenu(Scanner scan) {
       LennyLinkedTreeSet<Car> activeLot = LotService.getInstance().viewMainLot();

       activeLot.inOrderPrint();

       if(activeLot.isEmpty()){
           System.out.println("No cars for sale.");
       }else
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter vin to view car details: ");
            int vin = 0;
            try {
                vin = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("input failure");
                return;
            }
            if(vin == 0) return;
            if (LotService.getInstance().exists(vin)) {
                new CarDetailMenu(activeUser, LotService.getInstance().getCar(vin)).showMenu(scan);
                break;
            }
        }

    }
}
