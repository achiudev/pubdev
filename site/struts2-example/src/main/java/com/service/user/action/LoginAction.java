package com.service.user.action;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // all struts logic here
    public String execute() {

        return "SUCCESS";

    }
}
