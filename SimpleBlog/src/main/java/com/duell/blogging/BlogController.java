package com.duell.blogging;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.validator.CommentValidator;

@Controller
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
	 * 
	 * TODO - Make it look nicer when there is no list of blogs returned (either
	 * no blog, or nothing returned for tag search)
	 * 
	 * TODO - implement paging 
	 * TODO - Anchor the menu links to the top 
	 * TODO - Implement posting a comment on a comment. 
	 * TODO - implement some way to hide the reply box to a comment until it is needed 
	 *  
	 * TODO - Make the table size consistent
	 * 
	 * TODO - add a field in the comments for comment time 
	 * TODO - implement some sort of AOP for logging
	 */
	@Autowired
	@Qualifier("bloggingServiceBean")
	private BloggingService bloggingService;

//	public BlogController()
//	{
//		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//		
//		bloggingService = (BloggingService)appContext.getBean("bloggingServiceBean");
//		
//	}
	@Autowired
	private CommentValidator commentValidator;

	//Should be the same Model attribute as declared in the jsp and below.
	@InitBinder("comment")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(commentValidator);
	}

	@RequestMapping("/home")
	public String showHome(Map<String, Object> map) {
		// TODO look more into spring regarding this map parameter
		/*
		 * Pulls in all the blog entries.
		 */
		List<UIBlogEntry> blogs = bloggingService.listBlogEntries(5);
		map.put("blogEntries", blogs);
//		map.put("blogEntries", bloggingService.listBlogEntries(5));

		map.put("tagList", bloggingService.listTagEntries());
		map.put("title", "Blog Listing");

		return "home.page";
	}

	@RequestMapping("/blogView/{blogId}")
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

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ModelAndView addComment(
			@ModelAttribute("comment") @Valid UIComment comment,
			BindingResult result, Map<String, Object> map) {

		UIBlogEntry entry = bloggingService.getBlogById(comment
				.getParentBlogId());
		map.put("blogEntry", entry);
		map.put("tagList", bloggingService.listTagEntries());

		if (result.hasErrors()) {
			return new ModelAndView("blog.page", "comment", comment);
		}
		bloggingService.addComment(comment);

		return new ModelAndView("blog.page", "comment", new UIComment());
//		ModelAndView redirect = new ModelAndView("redirect:blogView/"
//				+ comment.getParentBlogId());

//		return redirect;
	}

	@RequestMapping(value = "/viewTag", method = RequestMethod.GET)
	public String showBlogMatchingTag(@RequestParam("tag") Integer tagID,
			Map<String, Object> map) {
		List<UIBlogEntry> blogs = bloggingService.getBlogsWithTag(tagID);
		String tagText = bloggingService.getTagName(tagID);
		map.put("blogEntries", blogs);
		map.put("title", "Blogs for " + tagText);
		map.put("tagList", bloggingService.listTagEntries());

		return "home.page";
	}
}
