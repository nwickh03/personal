import com.lennys.exception.DBException;
import com.lennys.model.people.User;
import com.lennys.ui.MainMenu;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

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

        try {
            ConnectionUtil.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        new MainMenu().showMenu(scan);





        try {
            ConnectionUtil.closeConnection();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
