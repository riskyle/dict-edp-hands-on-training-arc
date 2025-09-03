package challenge.day2;

import java.util.Scanner;

public class SearchingStrings {
	
	/* Day 2 – Searching Strings
	 * Challenge: Implement indexOf() manually, and create a word frequency counter.
	 * Objectives: Linear search, loop mastery.
	 * Best Practice Tip: Avoid nested loops unless necessary.
	 * Success Criteria: Program finds all occurrences correctly.
	 */
	
//	public static int indexOf(String search) {
//		
//		return 0;
//	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String myStr = "Hello planet earth, you are a great planet.";
		
		String toFind = "";
		
		for(int i = 0; i < myStr.length(); i++) {
			System.out.println(i +" "+ myStr.charAt(i));
			toFind += myStr.charAt(i);
			if("planet".equals(toFind)) {
				System.out.println("FOUND!");
				break;
			}
		}
	}
}
