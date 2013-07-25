package com.duell.blogging.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duell.blogging.form.BlogTagEntry;
import com.duell.blogging.form.TagEntry;

@Repository
public class TagsDAOImpl implements TagsDAO {

	static Logger log = Logger.getLogger(TagsDAOImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TagEntry> getAllTags() {
		return sessionFactory.getCurrentSession().createQuery("from TagEntry")
				.list();
	}

	@Override
	public List<TagEntry> getAllTagsForBlogById(Integer id) {

		Session session = sessionFactory.getCurrentSession();

//		List<TagEntry> blarg = null;
//		blarg = session.createQuery("from TagEntry te join ")
		
		
		
		List<BlogTagEntry> blogTagList = session
				.createQuery("from BlogTagEntry bte where bte.blogId=:theId")
				.setParameter("theId", id).list();

		StringBuffer sb = new StringBuffer("BlogTagEntries Returned={");
		for (BlogTagEntry blogTag : blogTagList) {
			sb.append(String.format("[tagid=%d blogid=%d]", blogTag.getTagId(),
					blogTag.getBlogId()));
		}
		sb.append("}");
		log.debug(sb.toString());

		List<TagEntry> tagList = new ArrayList<TagEntry>();

		for (BlogTagEntry blogTag : blogTagList) {
			log.debug("Getting tag text for tagid=" + blogTag.getTagId());
			
			List list = session.createQuery("from TagEntry te where te.id=:id")
					.setParameter("id", blogTag.getTagId()).list();

			log.debug("list retrieved for tagID=" + blogTag.getTagId()
					+ " is:" + list);

			tagList.addAll(list);
		}
		log.debug("Full Tag list returned is:" + tagList);

		return tagList;
	}
}
