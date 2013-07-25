package com.duell.blogging.view;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class UIBlogEntry {
	
	public UIBlogEntry()
	{}
	public UIBlogEntry(UIBlogEntry that)
	{
		this.id=that.id;
		this.title=that.title;
		this.content=that.content;
		this.author=that.author;
		this.author_contact=that.author_contact;
		this.publish_date=that.publish_date;
	}
	
	private Integer id;

	private String title;

	private String content;
	
	private String author;
	
	private String author_contact;
	
	private Date publish_date;
	
	private Collection<UITag> tags;
	
	private Collection<UIComment> comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor_contact() {
		return author_contact;
	}

	public void setAuthor_contact(String author_contact) {
		this.author_contact = author_contact;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Collection<UITag> getTags() {
		return tags;
	}
	public void setTags(Collection<UITag> tags) {
		this.tags = tags;
	}
	public Collection<UIComment> getComments() {
		return comments;
	}
	public void setComments(Collection<UIComment> comments) {
		this.comments = comments;
	}
	
	
}
