package challenge.day11;

public class Inheritance {
	
   /* Day 11 – Inheritance
	* Challenge: Base class Person, subclasses Student and Teacher. Each has unique behavior.
	* Objectives: Inheritance, method overriding.
	*/
	
	public static void main(String[] args) {
		Student student = new Student("Christian Kyle", 21, 4, "Mabini");
		Teacher teacher = new Teacher("Jee Ann Guinsod", 30, "Master I", "Mabini");
		
		System.out.println("**Student***");
		System.out.println("Student name: " + student.getName());
		System.out.println("Student age: " + student.getAge());
		System.out.println("Student section: " + student.getSection());
		System.out.println("Student grade level: " + student.getGradeLevel());
		student.addSubjects();
		student.viewAverageGrade();
		
		System.out.println("\n***Teacher***");
		System.out.println("Teacher name: " + teacher.getName());
		System.out.println("Teacher age: " + teacher.getAge());
		System.out.println("Teacher position: " + teacher.getPosition());
		System.out.println("Teacher section assign: " + teacher.getSectionAssign());
		teacher.addStudents();
	}

}

class Person{
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
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
	
	void setAge(int age) {
		this.age = age;
	}
}

class Student extends Person {
	private int gradeLevel;
	private String section;
	
	Student(String name, int age, int gradeLevel, String section){
		super(name, age);
		this.gradeLevel = gradeLevel;
		this.section = section;
	}
	
	String getSection(){
		return section;
	}
	
	void setSection(String section) {
		this.section = section;
	}
	
	int getGradeLevel() {
		return gradeLevel;
	}
	
	void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	void addSubjects() {
		System.out.println("Student can add subjects");
	}
	
	void viewAverageGrade() {
		System.out.println("View Average Grade");
	}
}

class Teacher extends Person{
	private String position;
	private String sectionAssign;
	
	Teacher(String name, int age, String position, String sectionAssign){
		super(name, age);
		this.position = position;
		this.sectionAssign = sectionAssign;
	}
	
	String getPosition() {
		return position;
	}
	
	void setPosition(String position) {
		this.position = position;
	}
	
	String getSectionAssign() {
		return sectionAssign;
	}
	
	void setSectionAssign(String sectionAssign) {
		this.sectionAssign = sectionAssign;
	}
	
	void addStudents() {
		System.out.println("Teacher can add students");
	}
}
