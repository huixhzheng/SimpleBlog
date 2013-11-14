package com.duell.util;

public interface Filter<T> {

	public boolean accept(T item);
}
