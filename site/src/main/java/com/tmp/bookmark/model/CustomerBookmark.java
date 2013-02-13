package com.tmp.bookmark.model;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerBookmark {

    String cust_id;
    String bookmark_location;

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getBookmark_location() {
        return bookmark_location;
    }

    public void setBookmark_location(String bookmark_location) {
        this.bookmark_location = bookmark_location;
    }

    @Override
    public String toString() {
        return "CustomerBookmark{" +
                "cust_id='" + cust_id + '\'' +
                ", bookmark_location='" + bookmark_location + '\'' +
                '}';
    }
}
