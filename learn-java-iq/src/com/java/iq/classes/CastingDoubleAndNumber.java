package com.java.iq.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Assign Double and Number types?
 * 
 * Double is a subclass of Number. Number cannot be assigned to Double variable.
 */
public class CastingDoubleAndNumber {

	public List<Double> doubleList = new ArrayList<>();

	public void addValue(Double doubleValue) {
		doubleList.add(doubleValue);
	}

	/**
	 * Cannot assign Number to a List of Double variable. 
	 * If tried to assign, compiler will throw an error.
	 */
	public void addValue(Number number) {
		// doubleList.add(number);
	}

	public static void main(String[] args) {

	}

}
