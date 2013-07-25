package com.duell.blogging.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "comments", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class CommentEntry {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "comment")
	private String comment;

	@Column(name = "commenter_name")
	private String commenterName;

	@Column(name = "commenter_email")
	private String commenterEmail;

	@Column(name = "parent_blog_id")
	private Integer parentId;

	@Column(name = "post_date")
	private Date postDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getCommenterEmail() {
		return commenterEmail;
	}

	public void setCommenterEmail(String commenterEmail) {
		this.commenterEmail = commenterEmail;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
