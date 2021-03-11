package com.lennys.ui;

import com.lennys.exception.DBException;
import com.lennys.model.people.User;
import com.lennys.model.things.Car;
import com.lennys.model.things.Offer;
import com.lennys.service.LotService;
import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

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


            try {
                System.out.println("***Make new offer");
                System.out.println(car.toStringSimple());
                System.out.println("Enter total amount offered:");
                double total = scan.nextDouble();
                scan.nextLine();
                System.out.println("Enter desired down payment:");
                double down = scan.nextDouble();
                scan.nextLine();
                System.out.println("Enter desired term(months):");
                int term = scan.nextInt();
                scan.nextLine();

                LotService.getInstance().makeOffer(new Offer(total,down, term, car.getVin(), activeUser.getUsername()));
                System.out.println("Your offer is pending.");
                return;
            } catch (InputMismatchException e) {
                System.out.println("offer failed");
            }


        }
    }


}
