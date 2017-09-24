package com.learn.spring.dao.impl;

import com.learn.spring.dao.HibernateDao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

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
