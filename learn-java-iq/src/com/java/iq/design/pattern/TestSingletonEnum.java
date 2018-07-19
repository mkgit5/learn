package com.java.iq.design.pattern;

public class TestSingletonEnum {
	public static void main(String[] args) {
		SingletonEnum singleton = SingletonEnum.INSTANCE;
		singleton.setValue(1);
		System.out.println(singleton.getValue());

		SingletonEnum singleton2 = SingletonEnum.INSTANCE;
		// singleton2.setValue(2);
		System.out.println(singleton2.getValue());

		System.out.println(singleton.hashCode());
		System.out.println(singleton2.hashCode());

	}
}
