package com.duell.blogging.view.page;

import java.util.Collection;

import com.duell.blogging.service.paging.PagingInfo;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UITag;

public class BlogListPageBean {

	Collection<UIBlogEntry> blogEntries;
	PagingInfo pagingInfo;
	Collection<UITag> sideTagEntries;
	
	
	public Collection<UIBlogEntry> getBlogEntries() {
		return blogEntries;
	}
	public void setBlogEntries(Collection<UIBlogEntry> blogEntries) {
		this.blogEntries = blogEntries;
	}
	public PagingInfo getPagingInfo() {
		return pagingInfo;
	}
	public void setPagingInfo(PagingInfo pagingInfo) {
		this.pagingInfo = pagingInfo;
	}
	public Collection<UITag> getSideTagEntries() {
		return sideTagEntries;
	}
	public void setSideTagEntries(Collection<UITag> sideTagEntries) {
		this.sideTagEntries = sideTagEntries;
	}
	@Override
	public String toString() {
		return "BlogListPageBean [blogEntries=" + blogEntries + ", pagingInfo="
				+ pagingInfo + ", sideTagEntries=" + sideTagEntries + "]";
	}
	
	
	
	
	
}
