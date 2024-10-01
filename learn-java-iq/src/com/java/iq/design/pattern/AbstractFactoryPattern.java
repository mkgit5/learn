package com.java.iq.design.pattern;

/*
 * Abstract Factory Pattern - Creational design pattern
 * 	- A super-factory which creates other factories.
 * 	- An interface is responsible for creating a factory of related objects without explicitly specifying their classes.  
 * 
 * Class Diagram:
 * 
 * 				Shape (I)								Color (I)
 * 		___________|___________					___________|___________
 * 	    |					  |					|					  |
 * 	Circle (C)				Square (C)		RedColor (C)			GreenColor (C)
 * 
 * 
 * 
 * 						AbstractFactory
 * 							+ getShape(String shapeType)
 * 							+ getColor(String colorName)
 *			_________________|_________________ 							
 * 			|								  |
 * 	 ShapeFactory (C)					ColorFactory (C)
 * 
 * 						FactoryProducer
 * 							+ getFactory(String factoryName)
 * 
 * How to use?
 * 	- ShapeFactory sf = FactoryProducer.getFactory("Shape");
 * 	  Shape sh = sf.getShape("Circle");
 * 	  sh.draw();
 *
 *  Output:
 *  	Shape -> Circle
 * 
 */
public class AbstractFactoryPattern {

	/**
	 * Abstract Factory
	 */
	abstract class AbstractFactory {
		abstract Shape getShape(String shapeType);

		abstract Color getColor(String colorName);
	}

	class FactoryProducer {
		public AbstractFactory getFactory(String factoryType) {
			if (factoryType == "Shape") {
				return new ShapeFactory();
			} else if (factoryType == "Color") {
				return new ColorFactory();
			}
			return null;
		}
	}

	/**
	 * ShapeFactory extending AbstractFactory
	 */
	class ShapeFactory extends AbstractFactory {

		@Override
		Shape getShape(String shapeType) {
			if (shapeType == "Circle") {
				return new Circle();
			} else if (shapeType == "Square") {
				return new Square();
			}
			return null;
		}

		@Override
		Color getColor(String colorName) {
			return null;
		}

	}

	/**
	 * ColorFacotry extending AbstractFactory
	 */
	class ColorFactory extends AbstractFactory {

		@Override
		Shape getShape(String shapeType) {
			return null;
		}

		@Override
		Color getColor(String colorName) {

			if (colorName == "red") {
				return new RedColor();
			} else if (colorName == "green") {
				return new GreenColor();
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

	interface Color {
		void fill();
	}

	class RedColor implements Color {

		@Override
		public void fill() {
			System.out.println("Fill -> Red");
		}

	}

	class GreenColor implements Color {

		@Override
		public void fill() {
			System.out.println("Fill -> Green");
		}

	}

	public static void main(String[] args) {
		AbstractFactoryPattern demo = new AbstractFactoryPattern();
		FactoryProducer factoryProducer = demo.new FactoryProducer();
		AbstractFactory shapeFactory = factoryProducer.getFactory("Shape");
		Shape shape = shapeFactory.getShape("Circle");
		shape.draw();

		AbstractFactory colorFactory = factoryProducer.getFactory("Color");
		Color color = colorFactory.getColor("red");
		color.fill();
	}

}
