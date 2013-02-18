package com.tmp.bookmark.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerAcc {
    private String customerID;
    private String email;
    private String password;
    private Timestamp registrationDate;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "CustomerAcc{" +
                "customerID='" + customerID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
