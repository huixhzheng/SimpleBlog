package com.duell.blogging.view;

public class UIComment {

	private String commenterName;
	private String commenterEmail;
	private String comment;
	private Integer parentBlogId;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getParentBlogId() {
		return parentBlogId;
	}
	public void setParentBlogId(Integer parentBlogId) {
		this.parentBlogId = parentBlogId;
	}
	
	
	
}
