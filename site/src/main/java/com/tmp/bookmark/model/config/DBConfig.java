package com.tmp.bookmark.model.config;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 14/02/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBConfig {
    private String db_url;
    private String db_user;
    private String db_password;

    public DBConfig() {
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    @Override
    public String toString() {
        return "DBConfig{" +
                "db_url='" + db_url + '\'' +
                ", db_user='" + db_user + '\'' +
                ", db_password='" + db_password + '\'' +
                '}';
    }
}
