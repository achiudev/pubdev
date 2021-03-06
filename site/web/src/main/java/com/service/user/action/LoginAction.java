package com.service.user.action;


import com.service.user.form.LoginForm;
import com.tmp.bookmark.di.CustomerAccDataInterface;
import com.tmp.bookmark.di.CustomerDataInterface;
import com.tmp.bookmark.model.Customer;
import com.tmp.bookmark.model.CustomerAcc;
import com.tmp.bookmark.util.ConfigurationConstants;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends BaseAction {
	private Customer customer = null;
    private String index;
	private LoginForm loginForm;

    private Connection con;

    // all struts logic here
    public String execute() {
        if (index != null && index.equals("Index")) {
            return "index";
        }

        HttpServletRequest request = ServletActionContext.getRequest();

        customer = authenticateCustomer();

        if (customer == null) {
            request.setAttribute("messages", messages);
            addActionError("LoginAction", getText("error.general.authentication_failed"));
            return "input";
        } else {
            request.getSession().setAttribute(ConfigurationConstants.CUSTOMER_BEAN_KEY, customer);
          //  request.setAttribute("customer", customer);
		}

        return "success";
    }

    private Customer authenticateCustomer() {
		CustomerAcc customerAcc;

        con = connectionManager.getConnection();

        customerAcc = CustomerAccDataInterface.getInstance().getCustomerByEmail(con, loginForm.getEmail());

		if (customerAcc != null) {
			customer = CustomerDataInterface.getInstance().getCustomerByID(con, customerAcc.getCustomerID());
		}

        return customer;
    }

    public void validate() {
        if (loginForm.getEmail().length() == 0) {
            addFieldError("loginForm.email", getText("error.general.email"));
        }
        if (loginForm.getPassword().length() == 0) {
            addFieldError("loginForm.password", getText("error.general.password"));
        }
    }

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
}
