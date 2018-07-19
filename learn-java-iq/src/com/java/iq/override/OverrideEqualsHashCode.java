package com.java.iq.override;

import java.util.Arrays;
import java.util.List;

public class OverrideEqualsHashCode {
	private int age;
	private List<String> name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverrideEqualsHashCode other = (OverrideEqualsHashCode) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Starting...");
		OverrideEqualsHashCode code = new OverrideEqualsHashCode();
		code.name = Arrays.asList("Manju", "Kogunde");

		OverrideEqualsHashCode code1 = new OverrideEqualsHashCode();
		code1.name = Arrays.asList("Manju", "Kogunde");

		System.out.println(code.hashCode());
		System.out.println(code1.hashCode());
		System.out.println(code.equals(code1));

	}

}
