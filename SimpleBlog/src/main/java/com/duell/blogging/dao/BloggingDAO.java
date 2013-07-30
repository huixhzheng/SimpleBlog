package com.duell.blogging.dao;

import java.util.Collection;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.service.paging.PagingInfo;

public interface BloggingDAO {

//	public Collection <BlogEntry> listBlogEntries();
	public Collection<BlogEntry> listBlogEntries(PagingInfo pageInfo);
	public Integer getBlogCount();
	public BlogEntry getBlogById(Integer id);
	public boolean addComment(CommentEntry comment);
	public Collection<BlogEntry> getBlogsByTag(Integer tagID);
}
