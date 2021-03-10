import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
import com.enterprise.results.TestResultsAPI;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;
import com.lennys.dao.JDBCUserDAO;
import com.lennys.exception.DBException;
import com.lennys.model.people.User;

import java.lang.reflect.Method;

@com.enterprise.annotations.TestClass
public class TestClass<A> {

    @TestMethod
    public MetaTestData<?,?> testTestMethod(){
        return new MetaTestData<>();
    }

    @TestMethod
    public  MetaTestData<String,A> testUserDAOReadOne(){
        MetaTestData<String, A> tr = new MetaTestData<>();
        tr.setExpected(new User("lenny","lll","555-867-5309","lenny@lll.com").getPhoneNumber());
        try {
            tr = (MetaTestData<String, A>) TestResultsAPI.testString("555-867-5309",
                    new JDBCUserDAO().read("lenny").getPhoneNumber());
        } catch (DBException e) {
            tr.setActual(null);
            tr.setMessage(e.getMessage());
            tr.setStatus(Status.ERRORED);
            return tr;
        }

        return tr;
    }


    public static void main(String[] args) {
        TestDiscovery t = new TestDiscovery();

        try {
            HashMap<Method,MetaTestData<?,?>> tr = t.runAndStoreTestInformation();
            System.out.println(tr);
        } catch (EnterpriseNoAppropriateConstructorFoundException e) {
            e.printStackTrace();
        }
    }
}
