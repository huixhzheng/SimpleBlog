package com.duell.blogging.view.converter;

import java.util.ArrayList;
import java.util.Collection;

import com.duell.blogging.view.decorator.UIDecorator;

public abstract class AbstractUIConverter<T,U> implements UIConverter<T,U>
{
	
	public T convertToUI(U dbObj,UIDecorator<T> decorator)
	{
		T uiObj = convertToUI(dbObj);
		if(decorator!=null)
		{
			uiObj = decorator.applyDecoration(uiObj);
		}
		return uiObj;
	}
	
	public Collection<T> convertToUI(Collection<U> dbObjList)
	{
		return convertToUI(dbObjList,null);
	}
	
	public Collection<T> convertToUI(Collection<U> dbObjList,UIDecorator<T> decorator)
	{
		Collection<T> convertedCollection = new ArrayList<T>();
		T uiObj;
		for(U u:dbObjList)
		{
			uiObj = convertToUI(u);
			if(decorator!=null)
			{
				uiObj=decorator.applyDecoration(uiObj);
			}
			convertedCollection.add(uiObj);
		}
		return convertedCollection;
	}
}
