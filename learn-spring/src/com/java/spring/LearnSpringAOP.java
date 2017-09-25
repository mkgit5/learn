package com.java.spring;

import com.java.spring.service.impl.LearnSpringServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringAOP {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		LearnSpringServiceImpl springService = context.getBean("learnSpringService", LearnSpringServiceImpl.class);
		// springService.getSquareAOP().getName();
		springService.getSquareAOP().setName("Square Name");
		// springService.getSquareAOP().setNameAndReturn("Square Name");
	}

}
