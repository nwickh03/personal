package com.lennys.ui;

import com.lennys.model.things.Car;
import com.lennys.service.LotService;

import java.util.Scanner;

public class RemoveCarMenu extends AbstractMenu {
    @Override
    public void showMenu(Scanner scan) {


        for (int i = 0; i < 3; i++) {

            System.out.println("*Remove car");
            System.out.println("enter vin");
            Integer vin = scan.nextInt();
            LotService.getInstance().removeCarFromLot(vin);
            System.out.println("removed car");



        }




    }
}
