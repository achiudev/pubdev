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
        return true;
    }

    public int updateCustomer(Connection con, Customer customer) {
        return 0;
    }
}
