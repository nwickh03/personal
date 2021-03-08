package com.lennys.ui;

import com.lennys.exception.DBException;
import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.service.LotService;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LotMenu extends AbstractMenu {
    User activeUser;
    LennyLinkedTreeSet<Car> activeLot;

    public LotMenu(User activeUser) { this.activeUser = activeUser;    }

    @Override
    public void showMenu(Scanner scan) {
       LennyLinkedTreeSet<Car> activeLot = LotService.getInstance().viewMainLot();
       activeLot.inOrderPrint();

        for (int i = 0; i < 3; i++) {
            Car c = activeLot.getByIntKey(987654321);

            System.out.println(c.getMake());


            System.out.println("Enter vin to view car details: ");
            int vin = scan.nextInt();
            scan.nextLine();
            if (activeLot.contains(new Car(vin))) {
                new CarDetailMenu(activeUser, activeLot.getByIntKey(vin)).showMenu(scan);
                break;
            }
        }

    }
}
