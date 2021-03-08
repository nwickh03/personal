package com.lennys.ui;

import java.util.Scanner;

public class MainMenu extends AbstractMenu {
    @Override
    public void showMenu(Scanner scan) {
        System.out.println("***WELCOME TO LENNY'S LEMON LOT***");
        boolean inMenu = true;
        do{
            System.out.println("Please Select:");
            System.out.println("[L]ogin");
            System.out.println("[R]egister");
            System.out.println("E[x]it");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("L")){
                (new LoginMenu()).showMenu(scan);
            }else if(answer.equalsIgnoreCase("R")){
                (new RegistrationMenu()).showMenu(scan);
            }else if(answer.equalsIgnoreCase("x")){
                break;
            }
        }while (inMenu);
    }
}
