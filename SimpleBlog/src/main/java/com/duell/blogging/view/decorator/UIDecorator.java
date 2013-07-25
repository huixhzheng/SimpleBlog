package com.duell.blogging.view.decorator;

public interface UIDecorator<T> {

	public T applyDecoration(T original);
}
