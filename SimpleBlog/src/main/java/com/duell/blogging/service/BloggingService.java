package com.duell.blogging.service;

import java.util.List;

import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;

public interface BloggingService {

	public List<UIBlogEntry>listBlogEntries();
	public List<UIBlogEntry>listBlogEntries(Integer maxNum);
	public UIBlogEntry getBlogById(Integer id);
	public boolean addComment(UIComment comment);
	public List<UIBlogEntry> getBlogsWithTag(Integer tagID);
	public String getTagName(Integer tagId);
	public List<UITag> listTagEntries();
}
