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
