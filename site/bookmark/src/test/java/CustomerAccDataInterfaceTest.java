import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerAccDataInterface;
import com.tmp.bookmark.model.CustomerAcc;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerAccDataInterfaceTest {
    private CustomerAcc customerAcc;
    private final String EMAIL = "t@1.com";
    private final String PASSWORD = "1234";
    private final String CUSTOMER_ID = "Tester";
    private ConnectionManager connectionManager;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        connectionManager = ConnectionManager.getInstance();
        con = connectionManager.getConnection();
    }

    @After
    public void tearDown() throws Exception {
        if (con != null) {
            connectionManager.closeConnection(con, true);
        }
    }

    //@Test
    public void testInsertCustomerAcc() throws Exception {
        Boolean result = false;

        customerAcc = new CustomerAcc();
        customerAcc.setCustomerID(CUSTOMER_ID);
        customerAcc.setEmail(EMAIL);
        customerAcc.setPassword(PASSWORD);

        result = CustomerAccDataInterface.getInstance().insertCustomerAcc(con, customerAcc);
        Assert.assertTrue(result);
    }

    //@Test
    public void testGetCustomerByEmail() throws Exception {
        customerAcc = CustomerAccDataInterface.getInstance().getCustomerByEmail(con, EMAIL);
        Assert.assertNotNull(customerAcc);
    }
}
