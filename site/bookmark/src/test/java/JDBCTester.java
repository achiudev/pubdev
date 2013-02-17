import com.tmp.bookmark.model.Bookmark;
import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerBookmark;
import com.tmp.bookmark.util.ConfigurationConstants;
import com.tmp.bookmark.util.FileUtil;
import com.tmp.bookmark.util.JSONUtil;
import org.json.JSONException;

import java.io.*;
import java.util.Vector;


public class JDBCTester {

    public static void main(String args[]) {
        try {

            //  Class.forName("com.mysql.jdbc.Driver");
            Vector<Customer> customers = new Vector<Customer>();
            CustomerBookmark cust_bookmark = null;

            //  Connection con = DriverManager.getConnection(dbUrl, "monty", "faaaaaaake");
          //  Connection con = ConnectionManager.getInstance().getConnection();

            /*  Customer customer = CustomerDataInterface.getInstance().getCustomerByID(con, "ABCD1234");

customers.add(customer);

for (Customer a : customers) {
System.out.println(a.getCustomerID() + "||" + a.getFirstName() + "||" + a.getLastName() + "||" + a.getCountry());
}                      */

     /*       cust_bookmark = CustomerBookmarkDataInterface.getInstance().getCustomerBookmarkByCustomerID(con, "ABCD1234");
            System.out.println(cust_bookmark.getCust_id() + "||" + cust_bookmark.getBookmark_location());

                                                                                                 */
            String contents = FileUtil.getInstance().getFileContents(ConfigurationConstants.JSON_FILES +"/json.txt");

         //   System.out.println(contents);

            FileUtil.getInstance().createAndWriteToFile(ConfigurationConstants.JSON_FILES,"json.txt",contents);

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

            //con.close();

            Vector<Bookmark> bookmarks = JSONUtil.getInstance().getBookmarks(contents);

            for (Bookmark a : bookmarks) {
                System.out.println(a.getDescription() + "--->" + a.getLink());
            }


        } //end try

       catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    } //end main
} //end class