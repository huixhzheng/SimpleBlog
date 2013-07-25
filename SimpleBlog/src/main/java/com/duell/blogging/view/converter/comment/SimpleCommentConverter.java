package com.duell.blogging.view.converter.comment;

import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.view.UIComment;
import com.duell.blogging.view.converter.AbstractUIConverter;

public class SimpleCommentConverter extends
		AbstractUIConverter<UIComment, CommentEntry> {

	@Override
	public UIComment convertToUI(CommentEntry dbObj) {
		
		UIComment uiComment = new UIComment();
	
		uiComment.setComment(dbObj.getComment());
		uiComment.setCommenterEmail(dbObj.getCommenterEmail());
		uiComment.setCommenterName(dbObj.getCommenterName());
		uiComment.setParentBlogId(dbObj.getParentId());
		
		return uiComment;
	}

}
