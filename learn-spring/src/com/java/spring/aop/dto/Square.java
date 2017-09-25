package com.java.spring.aop.dto;

import com.java.spring.aspect.Loggable;

import org.springframework.stereotype.Component;

@Component
public class Square {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		// throw new RuntimeException();
	}

	public String setNameAndReturn(String name) {
		this.name = name;
		return name;
	}

}
