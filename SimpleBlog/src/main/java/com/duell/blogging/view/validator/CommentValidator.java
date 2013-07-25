package com.duell.blogging.view.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.duell.blogging.view.UIComment;

@Component
public class CommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UIComment.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "comment.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commenterName", "commenterName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commenterEmail", "commenterEmail.required");
	}

}
