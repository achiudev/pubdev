package com.tmp.bookmark.util;

import com.tmp.bookmark.model.Bookmark;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: aapostol
 * Date: 12/02/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class JSONUtil {

    // apply singleton pattern
    protected JSONUtil() {
    }

    public static JSONUtil getInstance() {
        return jsonUtil;
    }

    public Vector<Bookmark>  getBookmarks(String contents) throws JSONException {

        JSONObject j_obj = new JSONObject(contents);
        JSONArray jsonBookmarks = j_obj.getJSONArray("bookmarks");
        Vector <Bookmark> bookmarks = new Vector<Bookmark>();

        for (int i = 0 ; i < jsonBookmarks.length(); i++){
            Bookmark temp = new Bookmark();
            temp.setDescription(jsonBookmarks.getJSONObject(i).get("description").toString());
            temp.setLink(jsonBookmarks.getJSONObject(i).get("link").toString());
            bookmarks.add(temp);
        }

       return bookmarks;
    }

    static JSONUtil jsonUtil = new JSONUtil();
}
