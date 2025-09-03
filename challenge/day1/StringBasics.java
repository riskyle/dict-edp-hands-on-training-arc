package challenge.day1;

import java.util.Scanner;

public class StringBasics {
	
	/*
	 *   Day 1 – Strings Basics
	 *  
	 *  Challenge: Write functions to reverse a string, count vowels/consonants, and check for palindromes.
		Objectives: String manipulation, functions, input/output.
		Success Criteria: Correct outputs with varied test cases.
		Time: 1.5 hrs.
	 * 
	 */
	public static String reversedString(String word) {
		String reversed = "";
		
		for(int i = word.length() - 1; i >= 0; i--) {
			reversed += word.charAt(i);
		}
		
		return reversed;
	}
	
	public static int countVowels(String word) {
		int count = 0;
		
		for (int i = 0; i < word.length(); i++) {
			char letter = word.toUpperCase().charAt(i);
		
			if(letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Type a word: ");
		String word = scanner.nextLine();
		
		System.out.println(countVowels(word));
		System.out.println(reversedString(word));
		
		
		scanner.close();
	}
}
