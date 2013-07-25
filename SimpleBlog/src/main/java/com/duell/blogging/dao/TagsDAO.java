package com.duell.blogging.dao;

import java.util.List;

import com.duell.blogging.form.TagEntry;

public interface TagsDAO {

	public List<TagEntry> getAllTags();
	public List<TagEntry> getAllTagsForBlogById(Integer id);
}
