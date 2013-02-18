package com.tmp.bookmark.di;

import com.tmp.bookmark.model.CustomerBookmark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerBookmarkDataInterface {
    static CustomerBookmarkDataInterface instance = new CustomerBookmarkDataInterface();

    protected CustomerBookmarkDataInterface() {
    }

    public static CustomerBookmarkDataInterface getInstance() {
        return instance;
    }

    public boolean insertCustomerBookmark(Connection con, CustomerBookmark customerBookmark) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO CUST_BOOKMARK (CUST_ID, BOOKMARK_LOCATION) VALUES (?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerBookmark.getCust_id());
            pstmt.setString(2, customerBookmark.getBookmark_location());

            result = (pstmt.executeUpdate() == 1);

        } catch (SQLException sqle) {
          sqle.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean updateCustomerBookmark(Connection con, CustomerBookmark customerBookmark) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE CUST_BOOKMARK SET BOOKMARK_LOCATION = ? WHERE CUST_ID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerBookmark.getBookmark_location());
            pstmt.setString(2, customerBookmark.getCust_id());

            result = (pstmt.executeUpdate() == 1);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean removeCustomerBookmark(Connection con, CustomerBookmark customerBookmark) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "DELETE FROM CUST_BOOKMARK WHERE CUST_ID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerBookmark.getCust_id());

            result = (pstmt.executeUpdate() == 1);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public CustomerBookmark getCustomerBookmarkByCustomerID(Connection con, String customerId) {
        PreparedStatement pstmt = null;
        CustomerBookmark cust_bookmark = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT B.CUST_ID, B.BOOKMARK_LOCATION FROM CUSTOMER A JOIN CUST_BOOKMARK B ON A.CUST_ID = B.CUST_ID " +
                    "WHERE B.CUST_ID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                cust_bookmark = new CustomerBookmark();
                cust_bookmark.setCust_id(rs.getString("CUST_ID"));
                cust_bookmark.setBookmark_location(rs.getString("BOOKMARK_LOCATION"));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
            }
        }

        return cust_bookmark;
    }
}
