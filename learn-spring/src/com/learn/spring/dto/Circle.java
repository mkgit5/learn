package com.learn.spring.dto;

public class Circle {// implements InitializingBean, DisposableBean {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @Override
	// public void afterPropertiesSet() throws Exception {
	// System.out.println("After bean initialization - " + id);
	// }
	//
	// @Override
	// public void destroy() throws Exception {
	// System.out.println("Before bean destruction");
	//
	// }

}
