package com.duell.blogging;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.duell.blogging.service.BloggingService;
import com.duell.blogging.service.paging.PagingInfo;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.page.BlogListPageBean;
import com.duell.blogging.view.validator.CommentValidator;

@Controller
@RequestMapping("/blog")
public class BlogController {

	/*
	 * TODO - DONE change each entry returned to only display the first x amount
	 * of words in the entry 
	 * TODO - DONE modify the blog tag cross reference
	 * table to have a unique pk id column and have the blog id + tag id just be
	 * foreign keys, not a part of the id of the table. 
	 * TODO - DONE Implement
	 * posting a comment 
	 * TODO - DONE Implement retrieving tags from the DB and
	 * displaying 
	 * TODO - DONE - ONGOING Look more into the hibernate way of
	 * retrieving things from the DB. ex joining things on retrieval and so on
	 * 
	 * TODO - DONE - TAG Search (both by selecting a single item from the bottom
	 * of a blog and via a list of all tags) 
	 * TODO - DONE Add some indicator for
	 * 'searched by tag x' at the top of the list of returned blogs searched by
	 * tag 'x' 
	 * TODO - DONE change this to the last 5 entries.
	 * 
	 * TODO - DONE implement validators
	 * TODO - DONE implement some sort of AOP for logging
	 * 
	 * TODO - Make it look nicer when there is no list of blogs returned (either
	 * no blog, or nothing returned for tag search)
	 * 
	 * TODO - DONE implement paging 
	 * TODO - DONE Anchor the menu links to the top 
	 * TODO - Implement posting a comment on a comment. 
	 * TODO - DONE implement some way to hide the reply box to a comment until it is needed 
	 *  
	 * TODO - DONE Make the table size consistent
	 * 
	 * TODO - add a field in the comments for comment time 
	 * 
	 * TODO - DONE - make it look nicer. (sort of done, not good with making it look 'good', only 1 actually good css theme)
	 * 
	 * TODO - add a section for 'favourite reads'. links to either blogs/books/whatever really
	 * 
	 * TODO - add an 'archive' section. Shows blog entries in chunks based upon month/year.
	 */
	@Autowired
	@Qualifier("bloggingServiceBean")
	private BloggingService bloggingService;

	@Autowired
	private CommentValidator commentValidator;

	//Should be the same Model attribute as declared in the jsp and below.
	@InitBinder("comment")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(commentValidator);
	}

	@RequestMapping("/home")
	public String showHome(@RequestParam(value="page",defaultValue="1") Integer pageNum,Map<String, Object> map) {
		/*
		 * Pulls in all the blog entries.
		 */
		PagingInfo pagingInfo = new PagingInfo(pageNum,5);
		BlogListPageBean pageBean = bloggingService.listBlogEntries(pagingInfo);
		map.put("blogEntries", pageBean.getBlogEntries());

		map.put("tagList", pageBean.getSideTagEntries());
		map.put("title", "Blog Listing");
		map.put("paging",pageBean.getPagingInfo());

		return "home.page";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllBlogs(Map<String,Object> map)
	{
		PagingInfo pageInfo = new PagingInfo(-1,-1);
		BlogListPageBean pageBean = bloggingService.listBlogEntries(pageInfo);
		
		map.put("blogEntries", pageBean.getBlogEntries());

//		map.put("tagList", pageBean.getSideTagEntries());
//		map.put("title", "Blog Listing");
//		map.put("paging",pageBean.getPagingInfo());
		
		return "home.page";
		
	}
	
	@RequestMapping(value="/{blogId}",method=RequestMethod.GET)
	public ModelAndView showBlog(@PathVariable("blogId") Integer blogId,
			Map<String, Object> map) {

		UIBlogEntry entry = bloggingService.getBlogById(blogId);

		map.put("blogEntry", entry);
		map.put("tagList", bloggingService.listTagEntries());
		/*
		 * "command" is a key looked for by the spring mvc framework. Sending a
		 * default Comment()
		 * Changed the form:form tag on the comments.jsp page to contain the 
		 * attribute modelAttribute="comment" this will change the default
		 * name being looked for from 'command' to 'comment'
		 */
		// return new ModelAndView("blog.page", "command", new UIComment());
		return new ModelAndView("blog.page", "comment", new UIComment());
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.POST)
	public ModelAndView addComment(@PathVariable("blogId") Integer blogId,			
			@ModelAttribute("comment") @Valid UIComment comment,
			BindingResult result, Map<String, Object> map)
	{
		/*
		 * Add comment first if there are no errors. This will save the 
		 * comment to the DB before retreiving the full page content.
		 */
		if(!result.hasErrors())
		{
			comment.setParentBlogId(blogId);
			bloggingService.addComment(comment);	
		}
		/*
		 * Pull the page content that has to be displayed regardless
		 * of error or no error.
		 */
		UIBlogEntry entry = bloggingService.getBlogById(comment
				.getParentBlogId());
		map.put("blogEntry", entry);
		map.put("tagList", bloggingService.listTagEntries());

		
		if (result.hasErrors()) 
		{
			//TODO figure out the proper way to return errors for json + spring
			return new ModelAndView("blog.page", "comment", comment);
		}

		return new ModelAndView("blog.page", "comment", new UIComment());
	}


	@RequestMapping(value = "/tags/{tagId}/blogs", method = RequestMethod.GET)
	public String showBlogMatchingTag(@PathVariable("tagId") Integer tagID,
			Map<String, Object> map) {
		BlogListPageBean pageBean = bloggingService.getBlogsWithTag(tagID);
		String tagText = bloggingService.getTagName(tagID);
		map.put("blogEntries", pageBean.getBlogEntries());
		map.put("title", "Blogs for " + tagText);
		map.put("tagList", pageBean.getSideTagEntries());

		return "home.page";
	}
	@RequestMapping(value="/tags",method=RequestMethod.GET)
	public ModelAndView getTags(Map<String,Object> map)
	{
		Collection<UITag> tags = bloggingService.listTagEntries();
		
		map.put("tags", tags);
		return new ModelAndView("tags.page");
	}
}
