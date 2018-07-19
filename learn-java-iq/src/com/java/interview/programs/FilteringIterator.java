package com.java.interview.programs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator filtering framework
 * @param <E>
 */
public class FilteringIterator<E> implements Iterator<E> {
	Iterator<E> iterator;
	IObjectTest<E> test;
	E nextItem;

	/**
	 * Parameterized constructor accepting an iterator instance and an instance of IObjectTest
	 * @param myIterator Iterator<E>
	 * @param myTest IObjectTest<E>
	 */
	public FilteringIterator(Iterator<E> myIterator, IObjectTest<E> myTest) {
		this.iterator = myIterator;
		this.test = myTest;
	}

	/**
	 * This method checks for the next item by skipping any objects which don't pass
	 * the IObjectTest<E> test() method.
	 */
	@Override
	public boolean hasNext() {
		while (iterator.hasNext()) {
			nextItem = iterator.next();
			if (test.test(nextItem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E next() {
		return nextItem;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}
}

/**
 * Interface with a test method
 * @param <E>
 */
interface IObjectTest<E> {
	boolean test(E obj);
}

/**
 * Class implementing IObjectTest to find the even numbers
 */
class CheckForEvenNumbers implements IObjectTest<Integer> {

	/**
	 * This method returns true if number is even, else returns false.
	 */
	@Override
	public boolean test(Integer obj) {
		if (obj.intValue() % 2 == 0)
			return true;
		return false;
	}

}

/**
 * A simple unit test for this framework
 */
class FilteringIteratorTest {

	/**
	 * Unit test case to print only even numbers by iterating through the list.
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating a list of integers
		final List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

		// Initialized FilteringIterator with another Iterator and an IObjectTest instance
		final Iterator<Integer> filteringIterator = new FilteringIterator<Integer>(integerList.iterator(), new CheckForEvenNumbers());

		// Iterating through the list
		while (filteringIterator.hasNext()) {
			System.out.println(filteringIterator.next());
		}

	}

}
