package com.service.user.action;

import com.tmp.bookmark.di.CustomerAccDataInterface;
import com.tmp.bookmark.di.CustomerDataInterface;
import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerAcc;

import java.sql.Connection;
import java.sql.SQLException;

import static com.tmp.bookmark.util.JavaUtil.generateCustomerID;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/18/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterAction extends BaseAction {
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String country;
    private String verify_password;

    private Connection con;

    public String execute() {
        String target = "success";

        Customer customer = initiateNewCustomer();

        if (customer == null) {
            addActionError("Registration_Duplicate", "Duplicate Email Address Dectected.");
            target = "input";
        }

        return target;
    }

    private Customer initiateNewCustomer() {
        con = connectionManager.getConnection();
        Customer customer = null;

        if (isCustomerDuplicate() == false) {
            customer = addNewCustomer();
            addNewCustomerAcc(customer);
        }

        return customer;
    }

    private void addNewCustomerAcc(Customer customer) {
        CustomerAcc customerAcc = new CustomerAcc();

        customerAcc.setCustomerID(customer.getCustomerID());
        customerAcc.setPassword(password);
        customerAcc.setEmail(email);

        CustomerAccDataInterface.getInstance().insertCustomerAcc(con, customerAcc);

        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer addNewCustomer() {
        String customerID = generateCustomerID(first_name, last_name);
        if (CustomerDataInterface.getInstance().getCustomerByID(con, customerID) != null) {
            addNewCustomer();
        }

        Customer customer = new Customer();
        customer.setFirstName(first_name);
        customer.setLastName(last_name);
        customer.setCountry(country);
        customer.setCustomerID(customerID);

        CustomerDataInterface.getInstance().insertCustomer(con, customer);

        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }



    private boolean isCustomerDuplicate() {
        Boolean result = true;
        if (CustomerAccDataInterface.getInstance().getCustomerByEmail(con, email) == null) {
            return false;
        }
        return result;
    }

    public void validate() {
        if (getEmail().length() == 0) {
            addFieldError("email", getText("error.general.email"));
        }
        if (getPassword().length() == 0) {
            addFieldError("password", getText("error.general.password"));
        }
        if (getVerify_password().length() == 0) {
            addFieldError("verify_password", getText("error.general.verify_password"));
        }
        if (getFirst_name().length() == 0) {
            addFieldError("first_name", getText("error.general.first_name"));
        }
        if (getLast_name().length() == 0) {
            addFieldError("last_name", getText("error.general.last_name"));
        }
        if (getCountry().length() == 0) {
            addFieldError("country", getText("error.general.country"));
        }

        if (!getPassword().equals(getVerify_password())) {
            addActionError("Registration", "Passwords do not match.");
        }
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVerify_password() {
        return verify_password;
    }

    public void setVerify_password(String verify_password) {
        this.verify_password = verify_password;
    }
}
