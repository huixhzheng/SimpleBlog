package com.duell.blogging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duell.blogging.dao.BloggingDAO;
import com.duell.blogging.dao.TagsDAO;
import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.form.TagEntry;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.converter.UIConverter;
import com.duell.blogging.view.converter.blogentry.SimpleUIBlogEntryConverter;
import com.duell.blogging.view.converter.tagentry.SimpleUITagConverter;
import com.duell.blogging.view.decorator.UIDecorator;
import com.duell.blogging.view.decorator.blogentry.ShortenDisplayContentDecorator;

@Service
public class BloggingServiceImpl implements BloggingService {

	@Autowired
	private BloggingDAO bloggingDAO;
	
	@Autowired
	@Qualifier("blogConverter")
	private UIConverter<UIBlogEntry,BlogEntry> blogConverter;
	
	@Autowired
	private TagsDAO tagsDAO;
	
	@Transactional
	public List<UIBlogEntry> listBlogEntries() {

		return listBlogEntries(-1);
	}
	@Transactional
	public List<UIBlogEntry>listBlogEntries(Integer maxNum)
	{
		/*
		 * Convert the objects coming back
		 */
		List<BlogEntry> blogEntries = bloggingDAO.listBlogEntries(maxNum); 
		List<UIBlogEntry> uiBlogEntries = null ;
		
//		UIConverter<UIBlogEntry,BlogEntry> converter=new SimpleUIBlogEntryConverter();
//		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
//		UIConverter<UIBlogEntry,BlogEntry> converter= (UIConverter<UIBlogEntry,BlogEntry>)appContext.getBean("uiBlogConverter");
		
		UIDecorator<UIBlogEntry> decorator=new ShortenDisplayContentDecorator(130);
	
//		uiBlogEntries = new ArrayList<UIBlogEntry>(converter.convertToUI(blogEntries, decorator));
		uiBlogEntries = new ArrayList<UIBlogEntry>(blogConverter.convertToUI(blogEntries, decorator));
		
		return uiBlogEntries;
	}

	@Transactional
	public UIBlogEntry getBlogById(Integer id)
	{
		//Retrieve data from DB and Extract from Map
		BlogEntry entry = bloggingDAO.getBlogById(id);
//		BlogEntry entry = (BlogEntry)map.get("blogEntry");
		
		//convert to UI
		UIConverter<UIBlogEntry,BlogEntry> converter = new SimpleUIBlogEntryConverter();
		UIBlogEntry uiBlogEntry = converter.convertToUI(entry);
		
		//place back in map
//		map.put("blogEntry", uiBlogEntry);
		
		//Retrieve the tag information from the DB
		/*List<TagEntry> tagList = tagsDAO.getAllTagsForBlogById(id);
		UIConverter<UITag,TagEntry> tagConverter = new SimpleUITagConverter();
		List<UITag> uiTagList = new ArrayList<UITag>(tagConverter.convertToUI(tagList));
		
		String tagListKey = "uiTagList";
		map.put(tagListKey, uiTagList);
*/		
		
//		return map;
		return uiBlogEntry;
	}
	@Transactional
	public boolean addComment(UIComment comment)
	{
		CommentEntry commentEntry =  new CommentEntry();
		commentEntry.setComment(comment.getComment());
		commentEntry.setCommenterEmail(comment.getCommenterEmail());
		commentEntry.setCommenterName(comment.getCommenterName());
		commentEntry.setParentId(comment.getParentBlogId());
		commentEntry.setPostDate(new Date());
		
		return bloggingDAO.addComment(commentEntry);
	}
	
	@Transactional
	public List<UITag> listTagEntries()
	{
		List<TagEntry> dbTags = tagsDAO.getAllTags();
		UIConverter<UITag,TagEntry> converter = new SimpleUITagConverter();
		List<UITag> uiTags = new ArrayList<UITag>(converter.convertToUI(dbTags));
	
		return uiTags;
	}
	@Transactional 
	public String getTagName(Integer tagID)
	{
		List<UITag> tags = listTagEntries();
		
		for(UITag tag:tags)
		{
			if(tag.getId().equals(tagID))
			{
				return tag.getText();
			}
		}
		return "";
	}
	
	@Transactional
	public List<UIBlogEntry> getBlogsWithTag(Integer tagID)
	{
		List<BlogEntry> dbBlogEntry = bloggingDAO.getBlogsByTag(tagID);
		UIConverter<UIBlogEntry,BlogEntry> converter = new SimpleUIBlogEntryConverter();
		
		return new ArrayList<UIBlogEntry>(converter.convertToUI(dbBlogEntry));
	}
	
}
