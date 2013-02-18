package com.service.user.action;

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
public class BaseAction {
    protected ConnectionManager connectionManager;
    protected Map<String, String> messages = new HashMap<String, String>();


    public BaseAction() {
        initAction();
    }

    private void initAction() {
        connectionManager = ConnectionManager.getInstance();
    }
}
