package com.java.iq.classes;

/*
 * A class extends another class (which is an inner class)
 * Class should define a constructor by passing Outer class instance.
 * Because Inner class is inaccessible with out the instance of an Outer class.
 * 
 * Here is a sample on how to define a constructor.
 */
public class ClassExtendingInnerClass extends Outer.Inner {

	/**
	 * Constructor with an argument of type Outer class.
	 * 
	 * @param outer Outer
	 */
	public ClassExtendingInnerClass(Outer outer) {
		outer.super();
	}

	/**
	 * Test method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final ClassExtendingInnerClass testNestedClasses = new ClassExtendingInnerClass(new Outer());
		System.out.println(testNestedClasses.fetchMemberB());
		// System.out.println(testNestedClasses.fetchMemberA()); // compile time error
	}

}

class Outer {

	int a = 1;

	public int fetchMemberA() {
		return a;
	}

	class Inner {
		int b = 2;

		public int fetchMemberB() {
			return b;
		}

	}
}
