package com.service.user.action;


import com.service.user.dao.LoginDAO;
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
	private CustomerAcc customerAcc;
    private String index;
	private LoginDAO loginDAO;

    private Connection con;

    // all struts logic here
    public String execute() {
        if (index != null && index.equals("Index")) {
            return "index";
        }

        HttpServletRequest request = ServletActionContext.getRequest();

        customerAcc = authenticateCustomer();

        if (customerAcc == null) {
            request.setAttribute("messages", messages);
            addActionError("LoginAction", getText("error.general.authentication_failed"));
            return "input";
        }

        return "success";
    }

    private CustomerAcc authenticateCustomer() {
        con = connectionManager.getConnection();

        customerAcc = CustomerAccDataInterface.getInstance().getCustomerByEmail(con, loginDAO.getEmail());

        return customerAcc;
    }

    public void validate() {
        if (loginDAO.getEmail().length() == 0) {
            addFieldError("loginDAO.email", getText("error.general.email"));
        }
        if (loginDAO.getPassword().length() == 0) {
            addFieldError("loginDAO.password", getText("error.general.password"));
        }
    }

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
