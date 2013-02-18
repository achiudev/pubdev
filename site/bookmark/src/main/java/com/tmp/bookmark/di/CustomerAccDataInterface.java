package com.tmp.bookmark.di;

import com.tmp.bookmark.model.CustomerAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerAccDataInterface {
    static CustomerAccDataInterface instance = new CustomerAccDataInterface();

    protected CustomerAccDataInterface() {
    }

    public static CustomerAccDataInterface getInstance() {
        return instance;
    }

    public boolean insertCustomerAcc(Connection con, CustomerAcc customerAcc) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO CUSTOMER_ACC (CUST_ID, EMAIL, PASSWORD, REGISTRATION_DATE) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerAcc.getCustomerID());
            pstmt.setString(2, customerAcc.getEmail());
            pstmt.setString(3, customerAcc.getPassword());

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

    public CustomerAcc getCustomerByEmail(Connection con, String email) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        CustomerAcc customerAcc = null;

        try {
            String sql = "SELECT CUST_ID, EMAIL, PASSWORD, REGISTRATION_DATE FROM CUSTOMER_ACC WHERE EMAIL = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                customerAcc = new CustomerAcc();
                customerAcc.setCustomerID(rs.getString("CUST_ID"));
                customerAcc.setEmail(rs.getString("EMAIL"));
                customerAcc.setPassword(rs.getString("PASSWORD"));
                customerAcc.setRegistrationDate(rs.getTimestamp("REGISTRATION_DATE"));
            }

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

        return customerAcc;
    }

}
