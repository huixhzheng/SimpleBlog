package com.duell.blogging.view.decorator.blogentry;

import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.decorator.UIDecorator;


public class SplitDisplayContentDecorator implements UIDecorator<UIBlogEntry>
{
	private int numChars;

	public int getNumChars() 
	{
		return numChars;
	}

	public void setNumChars(int numChars) 
	{
		this.numChars = numChars;
	}
	@Override
	public UIBlogEntry applyDecoration(UIBlogEntry original)
	{
		UIBlogEntry decoratedEntry = new UIBlogEntry(original);

		String originalContent = decoratedEntry.getContent();

		if (originalContent == null)
			return decoratedEntry;

		if (originalContent.length() <= numChars)
			return decoratedEntry;

		StringBuffer decoratedSB = new StringBuffer(originalContent.substring(
				0, numChars - 1));
		
		decoratedEntry.setContent(decoratedSB.toString());
		decoratedEntry.setContent2(originalContent.substring(numChars-1));
		
		return decoratedEntry;
	}

}
