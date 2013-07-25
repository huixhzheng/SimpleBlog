package com.duell.blogging.view.converter;

import java.util.Collection;

import com.duell.blogging.view.decorator.UIDecorator;

public interface UIConverter<T,U> {

	public T convertToUI(U dbObj);
	public T convertToUI(U dbObj,UIDecorator<T> decorator);
	
	public Collection<T> convertToUI(Collection<U> dbObjList);
	public Collection<T> convertToUI(Collection<U> dbObjList,UIDecorator<T> decorator);
}
