import java.util.Date;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.converter.UIConverter;
import com.duell.blogging.view.decorator.UIDecorator;
import com.duell.blogging.view.decorator.blogentry.ShortenDisplayContentDecorator;

public class TestAspect extends TestCase {

	public void testOne() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		BlogEntry blogEntry = new BlogEntry();
		blogEntry.setAuthor("author");
		blogEntry.setAuthor_contact("author@author.com");
		blogEntry.setContent("content yo");
		blogEntry.setPublish_date(new Date());
		blogEntry.setTitle("title yo");
		
		UIBlogEntry uiBlogEntry = new UIBlogEntry();
		UIConverter<UIBlogEntry, BlogEntry> converter = (UIConverter<UIBlogEntry, BlogEntry>) appContext
				.getBean("uiBlogConverter");
		UIDecorator<UIBlogEntry> decorator = new ShortenDisplayContentDecorator();
		((ShortenDisplayContentDecorator)decorator).setNumChars(130);
		
		uiBlogEntry = converter.convertToUI(blogEntry, decorator);
		
		
	}
}
