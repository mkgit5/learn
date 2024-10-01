package com.java.iq.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * Input: JAVA, J2EE, JSP, SERVLETS, JAVA, STRUTS, JSP
 * Ouput: JAVA, J2EE, JSP, SERVLETS, STRUTS
 * 
 * EG:
 * ArrayList With Duplicate Elements :[JAVA, J2EE, JSP, SERVLETS, JAVA, STRUTS, JSP]
 * ArrayList After Removing Duplicate Elements with HashSet:[JAVA, SERVLETS, JSP, J2EE, STRUTS]
 * ArrayList After Removing Duplicate Elements with LinkedHashSet:[JAVA, J2EE, JSP, SERVLETS, STRUTS]
 */
public class RemoveDuplicatesFromArrayList {

	public static void main(String[] args) {
		// Constructing an ArrayList
		final List<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");

		// Printing listWithDuplicateElements
		System.out.print("ArrayList With Duplicate Elements :");
		System.out.println(listWithDuplicateElements);

		// Constructing HashSet using listWithDuplicateElements
		final Set<String> set = new HashSet<String>(listWithDuplicateElements);

		// Constructing listWithoutDuplicateElements using set
		List<String> listWithoutDuplicateElements = new ArrayList<String>(set);

		// Printing listWithoutDuplicateElements
		System.out.print("ArrayList After Removing Duplicate Elements with HashSet:");
		System.out.println(listWithoutDuplicateElements);

		final Set<String> linkedHashSet = new LinkedHashSet<String>(listWithDuplicateElements);
		listWithoutDuplicateElements = new ArrayList<String>(linkedHashSet);
		System.out.print("ArrayList After Removing Duplicate Elements with LinkedHashSet:");
		System.out.println(listWithoutDuplicateElements);

	}

}
