package com.duell.blogging.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable("blogList")
	public BlogListPageBean listBlogEntries() {

		return listBlogEntries(new PagingInfo());
	}
	
	@Transactional
	@Cacheable(value={"blogListPage"})
	public BlogListPageBean listBlogEntries(PagingInfo pageInfo)
	{
		/*
		 * Convert the objects coming back
		 */
		BlogListPageBean blogListPageBean = new BlogListPageBean();
		Map<String,Object> map = bloggingDAO.listBlogEntries(pageInfo);
		
		Collection<BlogEntry> blogEntries =  (Collection<BlogEntry>)map.get("blogList");
		pageInfo = (PagingInfo)map.get("paging");
		
	
		List<UIBlogEntry> uiBlogEntries = null ;
		uiBlogEntries = new ArrayList<UIBlogEntry>(blogConverter.convertToUI(blogEntries, blogDecorator));

		
		
		blogListPageBean.setBlogEntries(uiBlogEntries);
		blogListPageBean.setPagingInfo(pageInfo);
		blogListPageBean.setSideTagEntries(listTagEntries());
		
		return blogListPageBean;
	}

	@Transactional
	@Cacheable(value="blogById")
	public UIBlogEntry getBlogById(Integer id)
	{
		BlogEntry entry = bloggingDAO.getBlogById(id);
		
		//convert to UI
		UIBlogEntry uiBlogEntry = blogConverter.convertToUI(entry);
		
		return uiBlogEntry;
	}
	
	@Transactional
	@CacheEvict(value={"blogList","blogListPage"}, allEntries=true)
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
	@Cacheable("tagList")
	public Collection<UITag> listTagEntries()
	{
		Collection<TagEntry> dbTags = tagsDAO.getAllTags();
		Collection<UITag> uiTags = new ArrayList<UITag>(tagConverter.convertToUI(dbTags));
	
		return uiTags;
	}
	@Transactional 
	@Cacheable("tagSingle")
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
	@Cacheable("blogByTag")
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
