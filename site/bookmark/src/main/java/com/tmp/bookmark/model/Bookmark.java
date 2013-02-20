package com.tmp.bookmark.model;

/**
 * Created with IntelliJ IDEA.
 * User: aapostol
 * Date: 14/02/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Bookmark {
    String description;
    String link;
	String name;
	String category;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
