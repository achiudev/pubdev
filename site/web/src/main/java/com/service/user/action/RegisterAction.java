package com.service.user.action;

import com.service.user.dao.LoginDAO;
import com.service.user.dao.RegisterDAO;
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
	private LoginDAO loginDAO;
	private RegisterDAO registerDAO;

    private Connection con;

    public String execute() {
        String target = "success";

        Customer customer = initiateNewCustomer();

        if (customer == null) {
            addActionError("Registration_Duplicate", "Duplicate Email Address Dectected.");
            target = "input";
        }

		loginDAO = new LoginDAO();

		loginDAO.setEmail(registerDAO.getEmail());

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
        customerAcc.setPassword(registerDAO.getPassword());
        customerAcc.setEmail(registerDAO.getPassword());

        CustomerAccDataInterface.getInstance().insertCustomerAcc(con, customerAcc);

        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer addNewCustomer() {
        String customerID = generateCustomerID(registerDAO.getFirst_name(), registerDAO.getLast_name());
        if (CustomerDataInterface.getInstance().getCustomerByID(con, customerID) != null) {
            addNewCustomer();
        }

        Customer customer = new Customer();
        customer.setFirstName(registerDAO.getFirst_name());
        customer.setLastName(registerDAO.getLast_name());
        customer.setCountry(registerDAO.getCountry());
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
        if (CustomerAccDataInterface.getInstance().getCustomerByEmail(con, registerDAO.getEmail()) == null) {
            return false;
        }
        return result;
    }

    public void validate() {
        if (registerDAO.getEmail().length() == 0) {
            addFieldError("registerDAO.email", getText("error.general.email"));
        }
        if (registerDAO.getPassword().length() == 0) {
            addFieldError("registerDAO.password", getText("error.general.password"));
        }
        if (registerDAO.getVerify_password().length() == 0) {
            addFieldError("registerDAO.verify_password", getText("error.general.verify_password"));
        }
        if (registerDAO.getFirst_name().length() == 0) {
            addFieldError("registerDAO.first_name", getText("error.general.first_name"));
        }
        if (registerDAO.getLast_name().length() == 0) {
            addFieldError("registerDAO.last_name", getText("error.general.last_name"));
        }
        if (registerDAO.getCountry().length() == 0) {
            addFieldError("registerDAO.country", getText("error.general.country"));
        }

        if (!registerDAO.getPassword().equals(registerDAO.getVerify_password())) {
           	addActionError("Registration", "Passwords do not match.");
        }

    }

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
}
