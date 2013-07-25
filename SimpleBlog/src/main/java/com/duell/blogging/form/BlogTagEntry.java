package com.duell.blogging.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tag_blog_reference",
		uniqueConstraints={@UniqueConstraint(columnNames={"tags_id","blog_id"})})

public class BlogTagEntry {

	@Id
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="tags_id")
	private Integer tagId;
	
	@Column(name="blog_id")
	private Integer blogId;
	
	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
