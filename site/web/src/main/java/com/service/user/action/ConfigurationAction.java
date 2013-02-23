package com.service.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tmp.bookmark.model.CustomerBookmark;

/**
 * Created by IntelliJ IDEA.
 * User: achiu
 * Date: 22/02/13
 * Time: 4:24 PM
 */
public class ConfigurationAction extends ActionSupport{

	private CustomerBookmark customerBookmark;


	public CustomerBookmark getCustomerBookmark() {
		return customerBookmark;
	}

	public void setCustomerBookmark(CustomerBookmark customerBookmark) {
		this.customerBookmark = customerBookmark;
	}

	public String execute() throws Exception {
		return "input";
	}
}
