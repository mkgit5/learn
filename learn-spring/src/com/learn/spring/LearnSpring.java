package com.learn.spring;

import com.learn.spring.dto.Circle;
import com.learn.spring.service.LearnSpringService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class LearnSpring {

	public static void main(String[] args) {
		// beanFactory();
		// fileSystemXmlPathApplicationContext();
		// classPathXmlApplicationContext();
		// abstractApplicationContext();
		// annotations();
		propertyPlaceHolder();
		// resourceBundle();
	}

	// String s = "abccdeff";
	// char[] charArray = s.toCharArray();
	// Arrays uniqueChars = new Arrays.[s.length()];
	//
	// for (int index = 0; index < charArray.length; index++) {
	// if (uniqueChars..contains(charArray[index])) {
	// uniqueChars.remove(index);
	// } else {
	// uniqueChars.add(charArray[index]);
	// }
	// }
	//
	// System.out.println(uniqueChars.toString());

	private static void beanFactory() {
		final BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("filepath-application-context.xml"));
		// final BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("filepath-application-context.xml"));
		final Circle circle = beanFactory.getBean("circle", Circle.class);
		System.out.println(circle.getId());
	}

	private static void fileSystemXmlPathApplicationContext() {
		final ApplicationContext context = new FileSystemXmlApplicationContext("filepath-application-context.xml");
		final Circle circle = context.getBean("circle", Circle.class);
		System.out.println(circle.getId());
	}

	private static void classPathXmlApplicationContext() {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		final Circle circle = context.getBean("circle", Circle.class);
		System.out.println(circle.getId());
	}

	private static void abstractApplicationContext() {
		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		context.registerShutdownHook();
		final Circle circle = context.getBean("circle", Circle.class);
		System.out.println(circle.getId());
	}

	private static void annotations() {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		final LearnSpringService learnSpringService = context.getBean("learnSpringService", LearnSpringService.class);
		learnSpringService.drawCircle(10);
	}

	private static void propertyPlaceHolder() {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath-application-context.xml");
		final LearnSpringService learnSpringService = context.getBean("learnSpringService", LearnSpringService.class);
		learnSpringService.drawCircle(10);
	}

	private static void resourceBundle() {
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:classpath-application-context.xml");
		final LearnSpringService learnSpringService = context.getBean("learnSpringService", LearnSpringService.class);
		learnSpringService.drawCircle(10);
	}

}
