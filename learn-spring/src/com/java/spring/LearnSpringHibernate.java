package com.java.spring;

import com.java.spring.dao.HibernateDao;
import com.java.spring.dao.impl.HibernateDaoImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringHibernate {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		final HibernateDao hibernateDao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(hibernateDao.getCircleCountByHql());
	}

}
