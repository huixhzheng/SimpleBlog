package com.duell.blogging.dao;

import java.util.List;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;

public interface BloggingDAO {

	public List<BlogEntry> listBlogEntries();
	public List<BlogEntry> listBlogEntries(int maxNum);
	public BlogEntry getBlogById(Integer id);
	public boolean addComment(CommentEntry comment);
	public List<BlogEntry> getBlogsByTag(Integer tagID);
}
