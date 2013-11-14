package com.duell.blogging.view;

public class UIComment {

	private String commenterName;
	private String commenterEmail;
	private String comment;
	private Integer parentBlogId;
	
	public UIComment()
	{
		
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((commenterEmail == null) ? 0 : commenterEmail.hashCode());
		result = prime * result
				+ ((commenterName == null) ? 0 : commenterName.hashCode());
		result = prime * result
				+ ((parentBlogId == null) ? 0 : parentBlogId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIComment other = (UIComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commenterEmail == null) {
			if (other.commenterEmail != null)
				return false;
		} else if (!commenterEmail.equals(other.commenterEmail))
			return false;
		if (commenterName == null) {
			if (other.commenterName != null)
				return false;
		} else if (!commenterName.equals(other.commenterName))
			return false;
		if (parentBlogId == null) {
			if (other.parentBlogId != null)
				return false;
		} else if (!parentBlogId.equals(other.parentBlogId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UIComment [commenterName=" + commenterName
				+ ", commenterEmail=" + commenterEmail + ", comment=" + comment
				+ ", parentBlogId=" + parentBlogId + "]";
	}
	
}
