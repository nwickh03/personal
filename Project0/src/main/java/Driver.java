import com.lennys.model.people.User;
import com.lennys.ui.CustomerLoginMenu;
import com.lennys.ui.EmployeeLoginMenu;
import com.lennys.ui.RegistrationMenu;
import com.lennys.util.LennyLinkedListSet;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("***WELCOME TO LENNY'S LEMON LOT***");
        LennyLinkedListSet<User> lll = new LennyLinkedListSet<User>();
        User a = new User("a","a","a", "a");
        User b = new User("c","a","a", "a");
        a = lll.get(b);
        a.getUsername();
        boolean inMenu = true;
        do{
            System.out.println("Please Select:");
            System.out.println("[L]ogin");
            System.out.println("[R]egister");
            System.out.println("[E]mployee Menu");
            System.out.println("E[x]it");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("L")){
                (new CustomerLoginMenu()).showMenu(scan);
            }else if(answer.equalsIgnoreCase("R")){
                (new RegistrationMenu()).showMenu(scan);
            }else if(answer.equalsIgnoreCase("E")){
                ((new EmployeeLoginMenu())).showMenu(scan);
            }
        }while (inMenu);



    }
}
