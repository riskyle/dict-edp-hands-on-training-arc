package challenge.week2.day14;

public class Association {
	
	/* Day 14 – Association
	 * Challenge: Student class references a Course class.
	 * Objectives: Understanding “uses-a” relationships.
	 */
	
	public static void main(String[] args) {
		Course course = new Course("BSIT", "Kyle", "7:30 am");
		String[] subj = {
				"Programming", 
				"Networking", 
				"Fundamentals of Programming", 
				"Data Strucutre and Algorithm"
				};
		course.addSubjects(subj);
		System.out.println("Display the subject of teacher " + course.getAdviser() + " course " + course.getName());
		for(String subject : course.subjects()) {
			System.out.println(subject);
		}
		
		Student student = new Student("Christian Kyle", 2, "Block A");
		student.addCourse(course);
		System.out.println("\nStudent " + student.getName() + " has a course of " + student.getCourse().getName());
		System.out.println("Students Subjcets:");
		for(String subject : student.getCourse().subjects()) {
			System.out.println(subject);
		}
	}
}

class Student{
	private String name;
	private int gradeLevel;
	private String section;
	private Course course;
	
	Student(String name, int gradeLevel, String section){
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.section = section;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	int getGradeLevel() {
		return gradeLevel;
	}
	
	void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	String getSection() {
		return section;
	}
	
	void setSection(String section) {
		this.section = section;
	}
	
	void addCourse(Course course) {
		this.course = course;
	}
	
	Course getCourse() {
		return course;
	}
}

class Course{
	private String name;
	private String adviser;
	private String schedule;
	private String[] subjects;
	
	Course(String name, String adviser, String schedule){
		this.name = name;
		this.adviser = adviser;
		this.schedule = schedule;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getAdviser() {
		return adviser;
	}
	
	void setAdviser(String adviser) {
		this.adviser = adviser;
	}
	
	String getSchedule() {
		return schedule;
	}
	
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	String[] subjects() {
		return subjects;
	}
	
	void addSubjects(String[] subjects) {
		this.subjects = subjects;
	}
}