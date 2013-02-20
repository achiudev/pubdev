package com.service.user.form;

/**
 * Created by IntelliJ IDEA.
 * User: achiu
 * Date: 19/02/13
 * Time: 3:29 PM
 */
public class RegisterForm {
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private String country;
	private String verify_password;


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

	@Override
	public String toString() {
		return "RegisterForm{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", country='" + country + '\'' +
				", verify_password='" + verify_password + '\'' +
				'}';
	}
}
