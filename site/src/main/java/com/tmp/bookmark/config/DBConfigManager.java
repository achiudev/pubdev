package com.tmp.bookmark.config;

import com.tmp.bookmark.model.config.DBConfig;
import com.tmp.bookmark.util.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 14/02/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBConfigManager {
    private final String USER_HOME = System.getProperty("user.home");
    private final String DB_ROOT_FOLDER_NAME = "dev";
    private final String DB_ROOT_FILE_NAME = "dbconfig.xml";
    private final String DB_ROOT_PATH = isNetworkPath(System.getProperty("user.home")) ? "\\" + USER_HOME : USER_HOME;
    private final String DB_FOLDER_PATH = DB_ROOT_PATH + File.separator + DB_ROOT_FOLDER_NAME;
    private final String DB_FILE_PATH = DB_FOLDER_PATH + File.separator + DB_ROOT_FILE_NAME;
    private final String TAG_DB_ROOT = "DBConfig";
    private final String TAG_DB_APPLICATION = "ApplicationDBConfig";
    private final String DB_ELEMENT_URL = "URL";
    private final String DB_ELEMENT_USERNAME = "Username";
    private final String DB_ELEMENT_PASSWORD = "Password";

    public static DBConfigManager instance;
    private DBConfig dbConfig;

    private DBConfigManager() {
        try {
            dbConfig = new DBConfig();
            initDBConfigurations();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB Initialization failed!");
        }
    }

    public static synchronized DBConfigManager getInstance() {
        if (instance == null) {
            instance = new DBConfigManager();
        }
        return instance;
    }

    public DBConfig getDBConfig() {
        return dbConfig;
    }

    private void initDBConfigurations() throws Exception {
        Document document = XMLUtil.ParseXmlToDom(DB_FILE_PATH);
        populateDBConfig(document);
    }

    private void populateDBConfig(Document doc) {
        if (doc.getDocumentElement().getNodeName().equals(TAG_DB_ROOT)) {
            NodeList nodeList = doc.getElementsByTagName(TAG_DB_APPLICATION);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    dbConfig.setDb_url(element.getElementsByTagName(DB_ELEMENT_URL).item(0).getTextContent());
                    dbConfig.setDb_user(element.getElementsByTagName(DB_ELEMENT_USERNAME).item(0).getTextContent());
                    dbConfig.setDb_password(element.getElementsByTagName(DB_ELEMENT_PASSWORD).item(0).getTextContent());
                }

            }
        }
    }

    private boolean isNetworkPath(String path) {
        return path.startsWith("\\");
    }


}
