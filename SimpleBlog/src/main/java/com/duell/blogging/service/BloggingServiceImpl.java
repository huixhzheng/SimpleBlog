package com.duell.blogging.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duell.blogging.dao.BloggingDAO;
import com.duell.blogging.dao.TagsDAO;
import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.form.TagEntry;
import com.duell.blogging.service.paging.PagingInfo;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.converter.UIConverter;
import com.duell.blogging.view.converter.blogentry.SimpleUIBlogEntryConverter;
import com.duell.blogging.view.decorator.UIDecorator;
import com.duell.blogging.view.page.BlogListPageBean;

@Service
public class BloggingServiceImpl implements BloggingService {

	@Autowired
	private BloggingDAO bloggingDAO;
	
	@Autowired
	@Qualifier("blogConverter")//Qualifier to specify a specific impl that is named in the xml
	private UIConverter<UIBlogEntry,BlogEntry> blogConverter;
	
	@Autowired
	@Qualifier("tagConverter")
	private UIConverter<UITag,TagEntry> tagConverter;
	
	@Autowired
	@Qualifier("blogDecorator")
	private UIDecorator<UIBlogEntry> blogDecorator;
	
	@Autowired
	private TagsDAO tagsDAO;
	
	@Transactional
	public BlogListPageBean listBlogEntries() {

		return listBlogEntries(new PagingInfo());
	}
	@Transactional
	public BlogListPageBean listBlogEntries(PagingInfo pageInfo)
	{
		/*
		 * Convert the objects coming back
		 */
		BlogListPageBean blogListPageBean = new BlogListPageBean();
		Collection<BlogEntry> blogEntries = bloggingDAO.listBlogEntries(pageInfo); 
	
		List<UIBlogEntry> uiBlogEntries = null ;
		uiBlogEntries = new ArrayList<UIBlogEntry>(blogConverter.convertToUI(blogEntries, blogDecorator));
	
		Integer numBlogs = bloggingDAO.getBlogCount();
		if(pageInfo.getPageNum() * pageInfo.getEntriesPerPage() < numBlogs)
		{
			pageInfo.setHasNext(true);
		}
		else
		{
			pageInfo.setHasNext(false);
		}
		
//		int startEntry = uiBlogEntries.get(0).getId();
//		int endEntry = uiBlogEntries.get(uiBlogEntries.size()-1).getId();
//		int pageNum = pageInfo.getPageNum();
//		if(startEntry > (pageInfo.getPageNum() * pageInfo.getEntriesPerPage()))
//		{
//			pageNum++;
//		}
//		else
//		{
//			pageNum--;
//		}
//		
		
		
		
		blogListPageBean.setBlogEntries(uiBlogEntries);
//		PagingInfo pageInfo2 = new PagingInfo(pageNum,pageInfo.getEntriesPerPage());
//		pageInfo2.setHasNext(true);
//		blogListPageBean.setPagingInfo(pageInfo2);
		blogListPageBean.setPagingInfo(pageInfo);
		blogListPageBean.setSideTagEntries(listTagEntries());
		
		return blogListPageBean;
	}

	@Transactional
	public UIBlogEntry getBlogById(Integer id)
	{
		BlogEntry entry = bloggingDAO.getBlogById(id);
		
		//convert to UI
		UIBlogEntry uiBlogEntry = blogConverter.convertToUI(entry);
		
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
	public Collection<UITag> listTagEntries()
	{
		Collection<TagEntry> dbTags = tagsDAO.getAllTags();
		Collection<UITag> uiTags = new ArrayList<UITag>(tagConverter.convertToUI(dbTags));
	
		return uiTags;
	}
	@Transactional 
	public String getTagName(Integer tagID)
	{
		Collection<UITag> tags = listTagEntries();
		
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
	public BlogListPageBean getBlogsWithTag(Integer tagID)
	{
		Collection<BlogEntry> dbBlogEntries = bloggingDAO.getBlogsByTag(tagID);
		
		BlogListPageBean pageBean = new BlogListPageBean();
		pageBean.setBlogEntries(blogConverter.convertToUI(dbBlogEntries));
		pageBean.setPagingInfo(null);
		pageBean.setSideTagEntries(listTagEntries());
		
		return pageBean;
	}
	
}
