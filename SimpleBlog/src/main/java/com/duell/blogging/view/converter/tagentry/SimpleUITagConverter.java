package com.duell.blogging.view.converter.tagentry;

import com.duell.blogging.form.TagEntry;
import com.duell.blogging.view.UITag;
import com.duell.blogging.view.converter.AbstractUIConverter;

public class SimpleUITagConverter extends AbstractUIConverter<UITag, TagEntry> {

	@Override
	public UITag convertToUI(TagEntry dbObj) {

		UITag uiTag = new UITag();
		uiTag.setId(dbObj.getId());
		uiTag.setText(dbObj.getText());

		return uiTag;
	}

}
