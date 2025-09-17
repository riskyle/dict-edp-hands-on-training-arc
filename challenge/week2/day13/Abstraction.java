package challenge.week2.day13;

public class Abstraction {
	
	/* Day 13 – Abstraction
	 * Challenge: Abstract Shape class with getArea() implemented by Circle, Rectangle.
	 * Objectives: Abstract classes, method contracts.
	 */

	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		rectangle.getArea();
		circle.getArea();
	}
}

abstract class Shape{
	abstract void getArea();
}

class Circle extends Shape {
	@Override
	void getArea() {
		System.out.println("50% 50%");
	}
}

class Rectangle extends Shape{
	@Override
	void getArea() {
		System.out.println("20%");
	}
}
