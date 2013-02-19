package com.tmp.bookmark.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/18/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaUtil {
    private static final int SEPARATOR_LENGTH = 3;
    private static final char SEPARATOR = '-';
    private static int DEFAULT_ID_LENGTH = 7;


    private static String generateUniqueID() {
        return RandomStringUtils.randomAlphanumeric(DEFAULT_ID_LENGTH);
    }

    public static String generateCustomerID(String first_name, String last_name) {
        String customerID;

        int first_length = first_name.length();
        int last_length = last_name.length();
        int sum = first_length + last_length + SEPARATOR_LENGTH + DEFAULT_ID_LENGTH;

        if (sum > 20) {
            if (first_length > 5) {
                first_name = first_name.substring(0,5);
            }

            if (last_length > 5) {
                last_name = last_name.substring(0,5);
            }
        }

        customerID = first_name + SEPARATOR + last_name + SEPARATOR + generateUniqueID();

        return customerID;
    }
}
