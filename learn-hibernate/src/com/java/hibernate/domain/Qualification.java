package com.java.hibernate.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Qualification {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
