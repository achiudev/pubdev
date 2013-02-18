import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerBookmarkDataInterface;
import com.tmp.bookmark.model.CustomerBookmark;
import org.junit.*;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 14/02/13
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerBookmarkDataInterfaceTest {
        private static ConnectionManager conMgr;
        private static Connection con;

        private String customerID="tester";
        private String bookmarkLoc="../test/bookmark.txt";

        private CustomerBookmark customerBookmark;


        /**                                              1
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
            customerBookmark = new CustomerBookmark();

            customerBookmark.setCust_id(customerID);
            customerBookmark.setBookmark_location(bookmarkLoc);
        }

        /**
         * Will perform the doMajorTearDown() after all tests have finished.
         */
        @AfterClass
        public static void afterClass() throws Exception {
            if (con != null) {
                conMgr.closeConnection(con, true);
            }
        }

        /**
         * Will perform the tearDown() after each test has finished.
         */
        @After
        public void tearDown() {
            customerBookmark = null;
        }


        /**
         * Method: readTextFileFromClassPath(String resourceItemPath)
         */
        //@Test
        public void testInsertCustomerBookmark() {
            Boolean result;

            result = CustomerBookmarkDataInterface.getInstance().insertCustomerBookmark(con, customerBookmark);
            Assert.assertTrue(result);
        }

        //@Test
        public void testUpdateCustomerBookmark() {
            Boolean result;

            customerBookmark.setBookmark_location("...");
            result = CustomerBookmarkDataInterface.getInstance().updateCustomerBookmark(con, customerBookmark);

            Assert.assertTrue(result);
        }

        //@Test
        public void testRemoveCustomerBookmark() {
            Boolean result = false;

            customerBookmark = CustomerBookmarkDataInterface.getInstance().getCustomerBookmarkByCustomerID(con,customerID);
            if (customerBookmark != null) {
                result = CustomerBookmarkDataInterface.getInstance().removeCustomerBookmark(con, customerBookmark);
            }

            Assert.assertTrue(result);
        }


}
