package com.tmp.bookmark.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionManager {
    private static ConnectionManager instance;
    private Connection connection;
    //asa

    private final String DB_URL = "jdbc:mysql://192.168.103.60:3306/maindb";
    final String DB_USER = "monty";
    final String DB_PASS = "some_pass";

    private ConnectionManager() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(Connection con, boolean commitTransUnit) throws SQLException {
        if(con == null){
            return;
        }

        try {
            if (commitTransUnit) {
                con.commit();
            } else {
                con.rollback();
            }
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
