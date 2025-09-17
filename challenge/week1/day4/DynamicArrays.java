package challenge.week1.day4;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArrays {
	
	/* Day 4 – Dynamic Arrays (ArrayList / Vector / List)
	 * Challenge: Implement a dynamic student list (add, search, delete).
	 * Objectives: Learn resizing and built-in dynamic list structures.
	 * Milestone Checkpoint #1: Can manipulate strings and arrays confidently.
	 */
	
	private static final int ADD_STUDENT = 1;
	private static final int SEARCH_STUDENT = 2;
	private static final int DELETE_STUDENT = 3;
	private static final int SHOW_STUDENTS = 4;
	private static final int QUIT = 0;
	
	static ArrayList<String> students = new ArrayList<String>();

	public static void addStudent(String student) {
		if(!student.equals(null)) {
			students.add(student);
		}
	}
	
	public static int searchStudent(String student) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).equals(student)) {
				System.out.println(students.get(i));
				return i;
			}
		}
		return -1;
	}
	
	public static void deleteStudent(String student) {
		if(!student.equals(null)) {
			int indexStudent = searchStudent(student);
			students.remove(indexStudent);
		}
	}
	
	public static ArrayList<String> showStudents(){
		return students;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		
		while(input != 0) {
			System.out.println("Input 1 - Add Student \nInput 2 - Search Student \nInput 3 - Delete Student on the List");
			System.out.print("Type your choice here: ");
			input = scanner.nextInt();
			
			scanner.nextLine(); // this line prevents to skip the first input

			if(input == ADD_STUDENT) {
				System.out.print("Add a student: ");
				String addedStudent = scanner.nextLine();
				addStudent(addedStudent);
			}else if(input == SEARCH_STUDENT) {
				System.out.print("Search a student: ");
				String searchStudent = scanner.nextLine();
				searchStudent(searchStudent);
			}else if(input == DELETE_STUDENT) {
				System.out.print("Delete a student: ");
				String deleteStudent = scanner.nextLine();
				deleteStudent(deleteStudent );
			}else if(input == SHOW_STUDENTS) {
				System.out.println(showStudents());
			}else if(input == QUIT) {
				break;
			}
		}
		
		scanner.close();
	}

}
