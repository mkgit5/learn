package com.java.spring.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.spring.dao.HibernateDao;

public class HibernateDaoImpl implements HibernateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long getCircleCountByHql() {
		final Session session = sessionFactory.openSession();
		final Query hqlQuery = session.createQuery("select count(*) from Triangle");
		return (long) hqlQuery.uniqueResult();
	}

}
