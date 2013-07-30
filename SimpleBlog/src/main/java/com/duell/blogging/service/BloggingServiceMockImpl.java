package com.duell.blogging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.duell.blogging.service.paging.PagingInfo;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.page.BlogListPageBean;

public class BloggingServiceMockImpl implements BloggingService {

	@Override
	public BlogListPageBean listBlogEntries() {
		return listBlogEntries(new PagingInfo());
	}

	@Override
	public BlogListPageBean listBlogEntries(PagingInfo info) {
		BlogListPageBean pageBean = new BlogListPageBean();
		List<UIBlogEntry> blogList = new ArrayList<UIBlogEntry>();
		
		int start = (info.getStartEntry()!=-1)?info.getStartEntry():1;
		int end =  (info.getEndEntry()!=-1)?info.getEndEntry():5;
		
		for(int i=start;i<end+1;i++)
		{
			UIBlogEntry fakeEntry = new UIBlogEntry();
			fakeEntry.setAuthor("fake author");
			fakeEntry.setComments(new ArrayList<UIComment>());
			fakeEntry.setContent("fake content");
			fakeEntry.setId(i);
			fakeEntry.setPublish_date(new Date());
			fakeEntry.setTags(new ArrayList<UITag>());
			fakeEntry.setTitle("fake title"+i);
			fakeEntry.setAuthor_contact("fake@email.com");
			blogList.add(fakeEntry);
		}
		pageBean.setBlogEntries(blogList);
		pageBean.setPagingInfo(new PagingInfo(info.getPageNum()+1,5));
		pageBean.setSideTagEntries(listTagEntries());
		return pageBean;
	}

	@Override
	public UIBlogEntry getBlogById(Integer id) {
		UIBlogEntry fakeEntry = new UIBlogEntry();
		fakeEntry.setAuthor("fake author");
		fakeEntry.setComments(new ArrayList<UIComment>());
		fakeEntry.setContent("fake content");
		fakeEntry.setId(id);
		fakeEntry.setPublish_date(new Date());
		fakeEntry.setTags(new ArrayList<UITag>());
		fakeEntry.setTitle("fake title");
		fakeEntry.setAuthor_contact("fake@email.com");
		return fakeEntry;
	}

	@Override
	public boolean addComment(UIComment comment) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BlogListPageBean getBlogsWithTag(Integer tagID) {
		
		return listBlogEntries(new PagingInfo());
	}

	@Override
	public String getTagName(Integer tagId) {
		// TODO Auto-generated method stub
		return "FakeTag";
	}

	@Override
	public List<UITag> listTagEntries() {
		List<UITag> tags = new ArrayList<UITag>();
		for(int i =0;i<5;i++)
		{
			UITag fakeTag = new UITag();
			fakeTag.setId(i);
			fakeTag.setText("FakeTag"+i);
			tags.add(fakeTag);
		}
		return tags;
	}

}
