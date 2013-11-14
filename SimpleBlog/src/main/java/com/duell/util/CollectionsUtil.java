package com.duell.util;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsUtil
{

	/**
	 * Returns a subset of the collection passed in based upon the Filter given.
	 * @param original
	 * @param filter
	 * @return
	 */
	public static <T> Collection<T> filterCollection(Collection<T> original, Filter<T> filter)
	{
		Collection<T> filtered = new ArrayList<T>();
		for (T item : original)
		{
			if (filter.accept(item))
			{
				filtered.add(item);
			}
		}
		return filtered;
	}
}
