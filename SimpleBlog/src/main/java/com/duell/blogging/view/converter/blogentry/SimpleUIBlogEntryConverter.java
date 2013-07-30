package com.duell.blogging.view.converter.blogentry;

import org.apache.log4j.Logger;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.form.TagEntry;
import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.converter.AbstractUIConverter;
import com.duell.blogging.view.converter.UIConverter;

public class SimpleUIBlogEntryConverter extends
		AbstractUIConverter<UIBlogEntry, BlogEntry> {

	Logger logger = Logger.getLogger(SimpleUIBlogEntryConverter.class);
	/*
	 * The two below converters will be autowired in via xml configuration.
	 * They require setter methods for xml autowiring.
	 * If using @Autowired annotation then setters would not be required
	 */
	private UIConverter<UITag, TagEntry> tagConverter;
	private UIConverter<UIComment, CommentEntry> commentConverter;

	public UIConverter<UITag, TagEntry> getTagConverter() {
		return tagConverter;
	}

	public void setTagConverter(UIConverter<UITag, TagEntry> tagConverter) {
		this.tagConverter = tagConverter;
	}

	public UIConverter<UIComment, CommentEntry> getCommentConverter() {
		return commentConverter;
	}

	public void setCommentConverter(
			UIConverter<UIComment, CommentEntry> commentConverter) {
		this.commentConverter = commentConverter;
	}

	@Override
	public UIBlogEntry convertToUI(BlogEntry blogEntry) {

		UIBlogEntry uiBlogEntry = new UIBlogEntry();

		uiBlogEntry.setId(blogEntry.getId());
		uiBlogEntry.setTitle(blogEntry.getTitle());
		uiBlogEntry.setAuthor(blogEntry.getAuthor());
		uiBlogEntry.setAuthor_contact(blogEntry.getAuthor_contact());
		uiBlogEntry.setPublish_date(blogEntry.getPublish_date());
		uiBlogEntry.setContent(blogEntry.getContent());

		uiBlogEntry.setTags(tagConverter.convertToUI(blogEntry.getTags()));

		uiBlogEntry.setComments(commentConverter.convertToUI(blogEntry
				.getComments()));

		return uiBlogEntry;
	}
}
