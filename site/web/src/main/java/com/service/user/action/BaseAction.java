package com.service.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tmp.bookmark.config.ConnectionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction extends ActionSupport {
    protected ConnectionManager connectionManager;
    protected Map<String, String> messages = new HashMap<String, String>();


    protected BaseAction() {
        initAction();
    }

    private void initAction() {
        connectionManager = ConnectionManager.getInstance();
    }

    public void addActionError(String key, String value) {
        //can log key here to make it easier to distinguish class
        addActionError(value);
    }

    public void addActionMessage(String key, String value) {
        //can log key here to make it easier to distinguish class
        addActionMessage(value);
    }


}
