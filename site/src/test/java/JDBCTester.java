import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerDataInterface;
import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerBookmark;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;


public class JDBCTester {

    public static void main(String args[]) {
        String dbtime;
        String dbUrl = "jdbc:mysql://192.168.117.128:3306/InitialDB";
        String dbClass = "com.mysql.jdbc.Driver";
        String query = "Select * FROM customer";

        try {

            //  Class.forName("com.mysql.jdbc.Driver");
            Vector<Customer> customers = new Vector<Customer>();
            CustomerBookmark cust_bookmark = null;

            //  Connection con = DriverManager.getConnection(dbUrl, "monty", "some_pass");
            Connection con = ConnectionManager.getInstance().getConnection();

          /*  Customer customer = CustomerDataInterface.getInstance().getCustomerByID(con, "ABCD1234");

            customers.add(customer);

            for (Customer a : customers) {
                System.out.println(a.getCustomerID() + "||" + a.getFirstName() + "||" + a.getLastName() + "||" + a.getCountry());
            }                      */

            cust_bookmark = CustomerDataInterface.getInstance().getBookmarkByCustomerID(con, "ABCD1234");
            System.out.println(cust_bookmark.getCust_id()+"||"+cust_bookmark.getBookmark_location());

           /* Scanner scanner =
                    new Scanner(new File(cust_bookmark.getBookmark_location())).useDelimiter("\\Z");
            String contents = scanner.next();
            System.out.println(contents);
            scanner.close();   */

            InputStream in = JDBCTester.class.getClassLoader().getResourceAsStream("resources/json_andrei.txt");
            try {
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                String line=null;
                while((line=reader.readLine())!=null){
                    System.out.println(line);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            con.close();
        } //end try

        catch (SQLException e) {
            e.printStackTrace();  }


    } //end main
} //end class