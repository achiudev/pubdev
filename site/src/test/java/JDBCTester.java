import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerDataInterface;
import com.tmp.bookmark.model.Bookmark;
import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerBookmark;
import com.tmp.bookmark.util.FileUtil;
import com.tmp.bookmark.util.JSONUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
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

            //  Connection con = DriverManager.getConnection(dbUrl, "monty", "faaaaaaake");
            Connection con = ConnectionManager.getInstance().getConnection();

            /*  Customer customer = CustomerDataInterface.getInstance().getCustomerByID(con, "ABCD1234");

customers.add(customer);

for (Customer a : customers) {  ss
System.out.println(a.getCustomerID() + "||" + a.getFirstName() + "||" + a.getLastName() + "||" + a.getCountry());
}                      */

            cust_bookmark = CustomerDataInterface.getInstance().getBookmarkByCustomerID(con, "ABCD1234");
            System.out.println(cust_bookmark.getCust_id() + "||" + cust_bookmark.getBookmark_location());


            String contents = FileUtil.getInstance().getFileContents("C:\\json_andrei.txt");

            /*   InputStream in = JDBCTester.class.getClassLoader().getResourceAsStream("resources/json_andrei.txt");
try {
BufferedReader reader=new BufferedReader(new InputStreamReader(in));
String line=null;
while((line=reader.readLine())!=null){
    System.out.println(line);
}
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}                */

            con.close();

            Vector<Bookmark> bookmarks = JSONUtil.getInstance().getBookmarks(contents);

            for (Bookmark a : bookmarks) {
                System.out.println(a.getDescription() + "--->" + a.getLink());
            }


        } //end try

        catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    } //end main
} //end class