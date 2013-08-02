package com.duell.blogging.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duell.blogging.form.BlogEntry;
import com.duell.blogging.form.CommentEntry;
import com.duell.blogging.service.paging.PagingInfo;

@Repository
public class BloggingDAOImpl implements BloggingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	// public Collection<BlogEntry> listBlogEntries() {
	//
	// return listBlogEntries(-1);
	// // return
	// sessionFactory.getCurrentSession().createQuery("from BlogEntry")
	// // .list();
	//
	// }
	@Override
	public Map<String,Object> listBlogEntries(PagingInfo pagingInfo) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		int start = 0;
		int end = 0;

		List<BlogEntry> list;
		
		// Use the Hibernate class name 'BlogEntry' and not the SQL table name
		// of blog_entries

		
		String strQuery = "from BlogEntry be order by be.id desc";
		Query queryObj = null;
		Session session = sessionFactory.getCurrentSession();
		// do range
		
		
		if (pagingInfo.getPageNum() != -1
				&& pagingInfo.getEntriesPerPage() != -1) {
			/*
			 * Get the latest entry
			 */
			BlogEntry latestEntry = (BlogEntry) session
					.createCriteria(BlogEntry.class).addOrder(Order.desc("id"))
					.setMaxResults(1).list().get(0);
			int latestEntryId = latestEntry.getId();

			int numEntries = pagingInfo.getEntriesPerPage();
			int pageNum = pagingInfo.getPageNum();

			// since going in reverse, the 'last' entry is really the first one.
			// Apply these as a delta value to apply to the
			// 'latestEntry.getId()' value. gives the shift in value needed
			/*
			 * pageNum=1 numEntries=5 -> firstEntry = 5 -> lastEntry = 5-5 = 0
			 * 
			 * apply the shift to the latestEntry.getId()
			 * 
			 * if latestEntry = 20 -> latestEntry - firstEntry = 20 - 5 = 15 ->
			 * latestEntry - lastEntry = 20 - 0 = 20
			 * 
			 * -> This gives us the latest chunk of entries
			 * 
			 * 
			 * if latestEntry = 20, pageNum=2, numEntries = 5 -> firstEntry = 10
			 * -> lastEntry = 5
			 * 
			 * -> latestEntryId - firstEntry = 20 - 10 = 10 -> latestEntryId -
			 * lastEntry = 20 - 5 = 15
			 */
			int firstEntry = pageNum * numEntries;
			int lastEntry = firstEntry - numEntries;

			end = latestEntryId - lastEntry;
			start = (latestEntryId - firstEntry) < 0 ? 0 : latestEntryId
					- firstEntry;

			if(start==0) //we've gone through it all
			{
				pagingInfo.setHasNext(false);
			}
			else
			{
				pagingInfo.setHasNext(true);
			}
			// TODO add some indicator that says if there are or aren't any more
			// items left.

			// start = ((end - numEntries) < 1) ? 1:end-numEntries; //Make sure
			// we don't go past the bottom of available entries

			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(BlogEntry.class)
					.add(Restrictions.le("id", end));
			crit = crit.add(Restrictions.gt("id", start));
			crit = crit.addOrder(Order.desc("id"));
			list = crit.list();
			
			
			// queryObj =
			// sessionFactory.getCurrentSession().createQuery(strRangeQuery);
			// queryObj = queryObj.setParameter("endPoint",
			// end).setParameter("startPoint", start);
		} else // get all
		{
			queryObj = sessionFactory.getCurrentSession().createQuery(strQuery);
			list = queryObj.list();
			pagingInfo.setHasNext(false);
		}
		
		map.put("blogList", list);
		map.put("paging", pagingInfo);
		return map;
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
		 * Performing a join like this results in a list of Object[] Object[0]
		 * is type BlogEntry Object[1] is type TagEntry (since BlogEntry.tags is
		 * TagEntry)
		 */
		List<Object[]> list = session
				.createQuery(
						"FROM BlogEntry be INNER JOIN be.tags t WHERE t.id IN (:tagID)")
				.setParameter("tagID", tagID).list();

		List<BlogEntry> blogEntries = new ArrayList<BlogEntry>();
		for (Object[] obj : list) {
			blogEntries.add((BlogEntry) obj[0]);
		}
		return blogEntries;
	}

	@Override
	public Integer getBlogCount()
	{
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(BlogEntry.class);
		List list = crit.list();
		return list.size();
	}
}
