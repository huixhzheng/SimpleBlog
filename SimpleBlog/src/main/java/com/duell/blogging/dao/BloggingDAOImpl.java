package com.duell.blogging.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;

@Repository
public class BloggingDAOImpl implements BloggingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<BlogEntry> listBlogEntries() {

		return listBlogEntries(-1);
//		return sessionFactory.getCurrentSession().createQuery("from BlogEntry")
//				.list();

	}
	@Override
	public List<BlogEntry> listBlogEntries(int maxNum)
	{
		List<BlogEntry> list;
		// Use the Hibernate class name 'BlogEntry' and not the SQL table name
		// of blog_entries
		String strQuery = "from BlogEntry be order by be.id desc";
		Query queryObj = sessionFactory.getCurrentSession().createQuery(strQuery);
		if(maxNum>0)
		{
			queryObj = queryObj.setMaxResults(maxNum);
		}
		list = queryObj.list();
		return list;
	}

	@Override
	public BlogEntry getBlogById(Integer id) {
		String singleBlogHQL = "from BlogEntry be where be.id = :id";

		List<BlogEntry> list = sessionFactory.getCurrentSession()
				.createQuery(singleBlogHQL).setParameter("id", id).list();
		BlogEntry entry = list.get(0);
		return entry;
	}

	@Override
	public boolean addComment(CommentEntry comment) {

		sessionFactory.getCurrentSession().save(comment);

		return true;
	}

	@Override
	public List<BlogEntry> getBlogsByTag(Integer tagID) {

		Session session = sessionFactory.getCurrentSession();
		
		/*
		 * Performing a join like this results in a list of Object[]
		 * Object[0] is type BlogEntry
		 * Object[1] is type TagEntry (since BlogEntry.tags is TagEntry)
		 */
		List<Object[]> list = session.createQuery(
				"FROM BlogEntry be INNER JOIN be.tags t WHERE t.id IN (:tagID)").setParameter(
				"tagID", tagID).list();
		
		List<BlogEntry> blogEntries = new ArrayList<BlogEntry>();
		for(Object[] obj:list)
		{
			blogEntries.add((BlogEntry)obj[0]);
		}
		return blogEntries;
	}

}
