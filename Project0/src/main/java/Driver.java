import com.lennys.model.people.User;
import com.lennys.ui.CustomerLoginMenu;
import com.lennys.ui.EmployeeLoginMenu;
import com.lennys.ui.RegistrationMenu;
import com.lennys.util.LennyLinkedTreeSet;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("***WELCOME TO LENNY'S LEMON LOT***");
        LennyLinkedTreeSet<User> lll = new LennyLinkedTreeSet<>();
        User a = new User("a","a","a", "a");
        User b = new User("b","a","a", "a");
        User c = new User("c","a","a", "a");

        lll.add(a);
        lll.add(c);
        lll.add(b);
        if(a.compareTo(b) < 0) System.out.println("a.compareTo(b) < 0");
        if(a.compareTo(b) > 0) System.out.println("a.compareTo(b) > 0");
        if("a".compareTo("c") < 0) System.out.println("a.compareTo(C < 0");
        if("a".compareTo("c") > 0) System.out.println("a.compareTo(C > 0");
        "a".compareTo("c");
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
