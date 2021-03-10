import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
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
    public  MetaTestData<?,?> testUserDAOReadOne(){
        MetaTestData<String, Object> tr = new MetaTestData<>();
        tr.setExpected(new User("lenny","lll","555-867-5309","lenny@lll.com").getPhoneNumber());
        try {
            tr.setActual(new JDBCUserDAO().read("lenny").getPhoneNumber());
        } catch (DBException e) {
            tr.setActual(null);
            tr.setStatus(Status.ERRORED);
            return tr;
        }
        if(tr.getExpected().equals(tr.getActual())){
            tr.setStatus(Status.PASSED);
        }else tr.setStatus(Status.FAILED);

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
