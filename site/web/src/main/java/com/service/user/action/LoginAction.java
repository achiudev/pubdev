package com.service.user.action;


import com.tmp.bookmark.config.ConnectionManager;
import com.tmp.bookmark.di.CustomerAccDataInterface;
import com.tmp.bookmark.model.CustomerAcc;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.COMM_FAILURE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends BaseAction {
    private String email = null;
    private String password = null;
    private CustomerAcc customerAcc = null;
    private Connection con;

    // all struts logic here
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();

        customerAcc = authenticateCustomer();

        if (customerAcc == null) {
            request.setAttribute("messages", messages);
            addActionError("LoginAction", "Login Failed.");
            return "input";
        }

        return "SUCCESS";
    }

    private CustomerAcc authenticateCustomer() {
        con = connectionManager.getConnection();

        customerAcc = CustomerAccDataInterface.getInstance().getCustomerByEmail(con, email);

        return customerAcc;
    }

    public void validate() {
        if (getEmail().length() == 0) {
            addFieldError("email", "Please enter an email.");
        }
        if (getPassword().length() == 0) {
            addFieldError("password", "Please enter a password.");
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
}
