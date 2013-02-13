package com.tmp.bookmark.di;

import com.tmp.bookmark.model.CustomerBookmark;

import java.sql.Connection;

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
        return true;
    }

    public boolean updateCustomerBookmark(Connection con, CustomerBookmark customerBookmark) {
        return true;
    }

    public CustomerBookmark getCustomerBookmarkByCustomerID(Connection con, String customerId) {
        CustomerBookmark customerBookmark = new CustomerBookmark();

        return customerBookmark;
    }
}
