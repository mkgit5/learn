package com.java.iq.test;

import java.util.Map;
import java.util.TreeMap;

public class TestJava {

	public static void main(String[] args) {
		Test t = new Test();
		Map<String, Integer> map = new TreeMap<>();

	}

	public void test(Test t1) {
		t1.s = "pqr";
		System.out.println("2 - " + t1.s);
	}

}

class Test {
	public String s = "abc";
}
