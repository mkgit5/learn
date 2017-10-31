package com.java.iq.classes;

/**
 * Reference variables have access to its member variables and methods only.
 */
public class TestPolymorphism {

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.fetchMember());

		B b = new B();
		System.out.println(b.fetchMember());
		System.out.println(b.fetchMemberOfClassB());
	}

}

class A {
	public int a = 1;

	public int fetchMember() {
		return a;
	}
}

class B extends A {
	public int b = 2;

	public int fetchMemberOfClassB() {
		return b;
	}
}