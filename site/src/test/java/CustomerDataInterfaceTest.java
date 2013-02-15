import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerDataInterface;
import com.tmp.bookmark.model.Customer;
import org.junit.*;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDataInterfaceTest {
    private static ConnectionManager conMgr;
    private static Connection con;


    /**
     * Will perform the doMajorSetUp() before the start of all tests.
     */
    @BeforeClass
    public static void initClass() throws Exception {
        conMgr = ConnectionManager.getInstance();
        con = conMgr.getConnection();
    }

    /**
     * Will perform the setUp() before each test
     */
    @Before
    public void setUp() {
    }

    /**
     * Will perform the doMajorTearDown() after all tests have finished.
     */
    @AfterClass
    public static void afterClass() throws Exception {
        if (con != null) {
            conMgr.closeConnection(con, false);
        }
    }

    /**
     * Will perform the tearDown() after each test has finished.
     */
    @After
    public void tearDown() {
    }


    /**
     * Method: readTextFileFromClassPath(String resourceItemPath)
     */
    //@Test
    public void testInsertCustomer() {

        Customer cust = new Customer();

        // create customer ID on timestamp, so new customer_id is added every day
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
        cust.setCustomerID("TEST"
                + formatter.format(Calendar.getInstance().getTimeInMillis()));

        cust.setFirstName("Andrew");
        cust.setLastName("Apostle");
        cust.setCountry("CA");

        boolean result = CustomerDataInterface.getInstance().insertCustomer(con, cust );

        assertTrue(result);


    }

    /**
     * Method: readTextFileFromClassPath(String resourceItemPath)
     */
    //@Test
    public void testUpdateCustomer() {

        Customer cust = new Customer();

        // create customer ID on timestamp, so new customer_id is added every day
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
        cust.setCustomerID("TEST"
                + formatter.format(Calendar.getInstance().getTimeInMillis()));

        cust.setFirstName("Andrew");
        cust.setLastName("Apostle");
        cust.setCountry("FR");

        boolean result = CustomerDataInterface.getInstance().updateCustomer(con, cust );

        assertTrue(result);


    }
}
