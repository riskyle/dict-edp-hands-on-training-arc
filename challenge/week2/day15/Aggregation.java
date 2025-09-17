package challenge.week2.day15;

import java.util.ArrayList;

public class Aggregation {
	
	/* Day 15 – Aggregation
	 * Challenge: Department has many Teachers, but teachers exist independently.
	 * Objectives: Aggregation vs association.
	 */
	
	public static void main(String[] args) {
		ArrayList<Teacher> englishTeachers = new ArrayList<>();
		englishTeachers.add(new Teacher("Jee Ann", 22, 0, "Teacher I"));
		englishTeachers.add(new Teacher("Eufee Mae", 20, 2, "Teacher II"));
		englishTeachers.add(new Teacher("Marilou Autor", 46, 20, "Teacher II"));

		ArrayList<Teacher> itTeachers = new ArrayList<>();
		itTeachers.add(new Teacher("Christian Kyle", 22, 5, "Software Developer"));
		itTeachers.add(new Teacher("Lenard", 22, 2, "IT Support"));
		itTeachers.add(new Teacher("Avril Labad", 50, 30, "Senior Software Developer"));
		itTeachers.add(new Teacher("John Doe", 19, 0, "Junior Developer"));
		
		Department englishDepartment = new Department("English");
		englishDepartment.addTeachers(englishTeachers);
		
		Department itDepartment = new Department("Information Technology");
		itDepartment.addTeachers(itTeachers);
		
		System.out.println("****" +englishDepartment.getName()+ " Teachers****");
		for(Teacher teacher : englishDepartment.getTeachers()) {
			System.out.println("Name: " + teacher.getName());
			System.out.println("Position: " + teacher.getPosition());
			int years = teacher.getYearsOfExperience();
			if(years != 0) {
				System.out.println("Years Of Experience :" + years +" "+ "years");				
			}
			System.out.println("Age: " + teacher.getAge() + "\n");
		}
		
		System.out.println("\n****" +itDepartment.getName()+ " Teachers****");
		for(Teacher teacher : itDepartment.getTeachers()) {
			System.out.println("Name: " + teacher.getName());
			System.out.println("Position: " + teacher.getPosition());
			int years = teacher.getYearsOfExperience();
			if(years != 0) {
				System.out.println("Years Of Experience :" + years +" "+ "years");				
			}
			System.out.println("Age: " + teacher.getAge() + "\n");
		}
		
	}
}

class Department{
	private String name;
	private ArrayList<Teacher> teachers;
	
	Department(String name){
		this.name = name;
	}
	
	ArrayList<Teacher> getTeachers(){
		return teachers;
	}
	
	void addTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
}

class Teacher{
	private String name;
	private int age;
	private int  yearsOfExperience;
	private String position;
	
	Teacher(String name, int age, int yearsOfExperience, String position){
		this.name = name;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
		this.position = position;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	int getAge() {
		return age;
	}
	
	void setAge(byte age) {
		this.age = age;
	}
	
	int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	void setYearsOfExperience(byte years) {
		yearsOfExperience = years;
	}
	
	String getPosition() {
		return position;
	}
	
	void setPosition(String position) {
		this.position = position;
	}
}

