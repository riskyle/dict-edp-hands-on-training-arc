package challenge.day12;

public class Polymorphism {
	
   /* Day 12 – Polymorphism
	* Challenge: Create an Animal class and subclasses (Dog, Cat, etc.), each with Speak().
	* Objectives: Polymorphism, dynamic dispatch.
	*/

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.speak();
		
		Animal dog = new Dog();
		dog.speak();
		
		Animal cat = new Cat();
		cat.speak();
		
		Animal lion = new Lion();
		lion.speak();
		
	}

}

class Animal{
	void speak() {
		System.out.println("Im just an animal class I can't speak rn.");
	}
}

class Dog extends Animal{
	@Override
	void speak() {
		System.out.println("Barf! Barf! Barf!");
	}
}

class Cat extends Animal{
	@Override
	void speak() {
		System.out.println("Meow! Meow! Meow!");
	}
}

class Lion extends Animal{
	@Override
	void speak() {
		System.out.println("Roar! Roar! Roar!");
	}
}