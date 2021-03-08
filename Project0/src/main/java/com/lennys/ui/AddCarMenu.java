package com.lennys.ui;

import com.lennys.model.things.Car;
import com.lennys.service.LotService;

import java.util.Scanner;

public class AddCarMenu extends AbstractMenu {
    @Override
    public void showMenu(Scanner scan) {


        for (int i = 0; i < 3; i++) {

            System.out.println("*Add car");
            System.out.println("enter vin");
            Integer vin = scan.nextInt();
            if(LotService.getInstance().exists(vin)){
                System.out.println("car already exists");
                continue;
            }else{
                scan.nextLine();
                System.out.println("enter year");
                Integer year = scan.nextInt();
                scan.nextLine();
                System.out.println("enter make");
                String make = scan.nextLine();
                System.out.println("enter model");
                String model = scan.nextLine();
                LotService.getInstance().addCarToLot(new Car(vin,year,make,model));
                System.out.println("added car with vin:  " + vin);
            }


        }




    }
}
