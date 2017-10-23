package com.java.iq.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TestJava {

	private final Character m_value = 'a';

	public String toString() {

		return "" + m_value;
	}

	public static void main(String[] args) {
		
		
		Map<Integer, String> map = new HashMap<Integer, String>(5);
		map.put(1, "apple");
		map.put(2, null);
		map.put(new Integer(3), "peach");
		map.put(3, "orange");
		map.put(4, "peach");
		
		
		for(String s : map.values()){
			if("orange".equals(s)){
				map.put(5, "banana");
			}
			
		}
		System.out.println(map.get(5));
		
		

//		try {
//			Field f = TestJava.class.getDeclaredField("m_value");
//			f.setAccessible(true);
//			TestJava a = new TestJava();
//			f.set(a, (char) 'b');
//			System.out.println(a);
//
//		} catch (Exception e) {
//
//		}
	}
}
