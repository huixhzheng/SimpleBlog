package com.duell.blogging.service;

import java.util.Collection;

import com.duell.blogging.service.paging.PagingInfo;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.page.BlogListPageBean;

public interface BloggingService {

	public BlogListPageBean listBlogEntries();
	public BlogListPageBean listBlogEntries(PagingInfo pagingInfo);
	public UIBlogEntry getBlogById(Integer id);
	public boolean addComment(UIComment comment);
	public BlogListPageBean getBlogsWithTag(Integer tagID);
	public String getTagName(Integer tagId);
	public Collection<UITag> listTagEntries();
}
