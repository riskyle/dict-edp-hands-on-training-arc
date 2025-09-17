package challenge.week2.day16;

public class Composition {
	
	/* Day 16 – Composition
	 * Challenge: Car has Engine, and engine cannot exist without car.
	 * Objectives: Strong lifecycle binding.
	 * Milestone Checkpoint #3: Can apply all 4 OOP pillars + relationships.
	 */

	public static void main(String[] args) {
		Car car1 = new Car("Ferrari", "red", "V8");
		Car car2 = new Car("Rols Royes", "dark blue", "donkey");
		
		car1.triggerStart();
		car2.triggerStart();
		
		car1.triggerStop();
		car2.triggerStop();
	}
}

class Car{
	private String model;
	private String color;
	private Engine engine;
	
	Car(String model, String color, String engineType){
		this.model = model;
		this.color = color;
		this.engine = new Engine(engineType);
	}
	
	String getModel() {
		return model;
	}
	
	void setModel(String model) {
		this.model = model;
	}
	
	String getColor() {
		return color;
	}
	
	void setColor(String color) {
		this.color = color;
	}
	
	void triggerStart() {
		engine.start();
	}
	
	void triggerStop() {
		engine.stop();
	}
}

class Engine{
	private String type;
	
	Engine(String type){
		this.type = type;
	}
	
	void start() {
		System.out.println(type + " engine is starting...");
	}
	
	void stop() {
		System.out.println(type + " engine is stopping...");
	}
	
	void setEngine(String type) {
		this.type = type;
	}
}