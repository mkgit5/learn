package com.java.iq.design.pattern;

/*
 * Factory Pattern - Creational design pattern
 * 	- Creates object without exposing the creation logic to the client  
 * 
 * Class Diagram:
 * 
 * 				Shape (I)
 * 		___________|___________
 * 	    |					  |
 * 	Circle (C)				Square (C)
 * 
 * 	ShapeFactory (C)
 * 		+ Shape getShape(String shapeType)
 * 
 */
public class FactoryPattern {

	class ShapeFactory {

		public Shape getShape(String type) {
			if (type == "Circle") {
				return new Circle();
			} else if (type == "Square") {
				return new Square();
			}
			return null;
		}

	}

	interface Shape {
		void draw();
	}

	class Circle implements Shape {
		@Override
		public void draw() {
			System.out.println("Shape -> Circle");
		}
	}

	class Square implements Shape {
		@Override
		public void draw() {
			System.out.println("Shape -> Square");
		}
	}

	/**
	 * Method to test factory pattern
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FactoryPattern factoryPattern = new FactoryPattern();
		ShapeFactory shapeFactory = factoryPattern.new ShapeFactory();
		shapeFactory.getShape("Circle").draw();
		shapeFactory.getShape("Square").draw();
	}

}
