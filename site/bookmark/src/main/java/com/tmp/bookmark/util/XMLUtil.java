package com.tmp.bookmark.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLUtil {
    public static Document ParseXmlToDom(String filePath) throws Exception {
        if (filePath == null) {
            throw new Exception("FilePath is null!");
        }

        File xmlFile = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.parse(xmlFile);

        return doc;
    }
}
