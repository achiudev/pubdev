package com.tmp.bookmark.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: achiu
 * Date: 11/02/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUtil {

    // apply singleton pattern
    protected FileUtil() {
    }

    public static FileUtil getInstance() {
        return fileUtil;
    }


    public String getFileContents(String path) throws FileNotFoundException {

        Scanner scanner =
                new Scanner(new File(path)).useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);
        scanner.close();

        return contents;
    }


    static FileUtil fileUtil = new FileUtil();
}
