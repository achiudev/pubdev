package com.service.user.action;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeAction extends BaseAction {
    private String register;
    private String login;

    public String execute() throws Exception {
        if (login != null && login.equals("Login")) {
            return "login";
        }
        if (register != null && register.equals("Register")) {
            return "register";
        }

        return super.execute();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
