package com.tmp.bookmark.util;

import java.io.*;
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

    public boolean createAndWriteToFile(String dirPath, String filename, String contents) throws IOException {

        File tempfile = new File(dirPath, filename);
        FileWriter fw;

        // if file doesnt exist, then create it
        if (!tempfile.exists()) {
            tempfile.createNewFile();
            fw = new FileWriter(tempfile.getAbsoluteFile());
        }
        else{
            // append to file, instead of overwriting
            fw = new FileWriter(tempfile.getAbsoluteFile(), true);
        }

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contents);
        bw.close();

        return true;
    }


    static FileUtil fileUtil = new FileUtil();
}
