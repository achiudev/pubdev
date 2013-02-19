package com.service.user.dao;

import com.tmp.bookmark.model.CustomerAcc;

/**
 * Created by IntelliJ IDEA.
 * User: achiu
 * Date: 19/02/13
 * Time: 3:29 PM
 */
public class LoginDAO {
	private String email = null;
	private String password = null;

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
