package com.duell.blogging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;

public class BloggingServiceMockImpl implements BloggingService {

	@Override
	public List<UIBlogEntry> listBlogEntries() {
		return listBlogEntries(5);
	}

	@Override
	public List<UIBlogEntry> listBlogEntries(Integer maxNum) {
		List<UIBlogEntry> blogList = new ArrayList<UIBlogEntry>();
		for(int i=0;i<maxNum;i++)
		{
			UIBlogEntry fakeEntry = new UIBlogEntry();
			fakeEntry.setAuthor("fake author");
			fakeEntry.setComments(new ArrayList<UIComment>());
			fakeEntry.setContent("fake content");
			fakeEntry.setId(i);
			fakeEntry.setPublish_date(new Date());
			fakeEntry.setTags(new ArrayList<UITag>());
			fakeEntry.setTitle("fake title");
			fakeEntry.setAuthor_contact("fake@email.com");
			blogList.add(fakeEntry);
		}
		return blogList;
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
	public List<UIBlogEntry> getBlogsWithTag(Integer tagID) {
		
		return listBlogEntries(5);
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
