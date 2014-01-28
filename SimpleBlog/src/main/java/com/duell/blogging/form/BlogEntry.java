package com.duell.blogging.form;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "blog_entries", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class BlogEntry {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "author")
	private String author;

	@Column(name = "author_contact")
	private String author_contact;

	@Column(name = "publish_date")
	private Date publish_date;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tag_blog_reference", joinColumns = { @JoinColumn(name = "blog_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "tags_id", referencedColumnName = "id") })
	private Set<TagEntry> tags;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parent_blog_id")
	private Set<CommentEntry> comments;

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

	public Set<TagEntry> getTags() {
		return tags;
	}

	public void setTags(Set<TagEntry> tags) {
		this.tags = tags;
	}

	public Set<CommentEntry> getComments() {
		return comments;
	}

	public void setComments(Set<CommentEntry> comments) {
		this.comments = comments;
	}

}
