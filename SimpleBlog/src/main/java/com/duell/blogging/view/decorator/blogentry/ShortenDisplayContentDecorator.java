package com.duell.blogging.view.decorator.blogentry;

import com.duell.blogging.view.UIBlogEntry;
import com.duell.blogging.view.decorator.UIDecorator;

public class ShortenDisplayContentDecorator implements UIDecorator<UIBlogEntry>{

	int numChars;
	public ShortenDisplayContentDecorator(int numCharsToInclude)
	{
		numChars=numCharsToInclude;
	}
	@Override
	public UIBlogEntry applyDecoration(UIBlogEntry blogEntry) {
		UIBlogEntry decoratedEntry = new UIBlogEntry(blogEntry);
	
		String originalContent = decoratedEntry.getContent();
		
		if(originalContent==null)
			return decoratedEntry;
		
		if(originalContent.length()<=numChars)
			return decoratedEntry;
	
		StringBuffer decoratedSB= new StringBuffer(originalContent.substring(0, numChars-1));
		decoratedSB.append("...");
		decoratedEntry.setContent(decoratedSB.toString());
		
		return decoratedEntry; 
	}

}
