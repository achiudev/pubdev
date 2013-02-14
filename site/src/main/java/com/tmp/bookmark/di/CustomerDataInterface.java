package com.tmp.bookmark.di;

import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerBookmark;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDataInterface {
    static CustomerDataInterface instance = new CustomerDataInterface();

    protected CustomerDataInterface() {

    }

    public static CustomerDataInterface getInstance() {
        return instance;
    }

    public Customer getCustomerByID(Connection con, String customerID) {
        PreparedStatement pstmt = null;
        Customer customer = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customerID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerID(rs.getString(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setCountry(rs.getString(4));
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

        return customer;
    }

    public boolean insertCustomer(Connection con, Customer customer) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO CUSTOMER (CUST_ID, FIRST_NAME, LAST_NAME, COUNTRY) VALUES (?,?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customer.getCustomerID());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getCountry());

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

    public boolean updateCustomer(Connection con, Customer customer) {
        boolean result = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE CUSTOMER SET FIRST_NAME = ?, LAST_NAME=?, COUNTRY= ? WHERE CUST_ID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getCountry());
            pstmt.setString(4, customer.getCustomerID());

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
}
