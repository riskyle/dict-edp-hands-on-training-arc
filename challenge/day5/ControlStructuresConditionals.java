package challenge.day5;

import java.util.Scanner;

public class ControlStructuresConditionals {
	
	/* 	Day 5 – Control Structures: Conditionals
	 *	Challenge: Grade calculator (input student marks, output letter grade with remarks).
	 *	Objectives: Nested if-else, validation.
	 *	Success Criteria: Works with edge cases (e.g., grade = 100 or 0).
	 */
	
	public static String awards(double resultGrade) {
		if(resultGrade >= 100) {
			return "With Highest Honor";
		}else if(resultGrade >= 91  && resultGrade <= 99) {
			return "With High Honor";
		}else if(resultGrade >= 85  && resultGrade <= 90) {
			return "With Honor";
		}else if(resultGrade >= 75){
			return "Passed";
		}else {
			return "Failed";
		}
	}
	
	public static String result(double countIteration, double resultGrade, double totalGrade) {
		if(countIteration != 0) {
			resultGrade = totalGrade / countIteration;
			return awards(resultGrade);
		}else {
			System.out.println("There is wrong when calculating the grades...");
			return null;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double resultGrade = 0, totalGrade = 0, inputGrade = 0;
		int countIteration = 0;
		
		System.out.println("If all done just input '-1'");
		
		while(true) {
			System.out.print("Write a grades: ");
			inputGrade = scanner.nextInt();
			
			if(inputGrade > 100) {
				System.out.println("Input Grade should not greater than 100.");
				continue;
			}
						
			if(inputGrade <= -1) {
				break;
			}else {
				totalGrade += inputGrade;
				countIteration++;
			}
		}
		
		System.out.println(result(countIteration, resultGrade, totalGrade));
		
		scanner.close();
	}

}
