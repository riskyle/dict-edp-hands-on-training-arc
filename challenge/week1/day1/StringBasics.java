package challenge.week1.day1;

import java.util.Scanner;

public class StringBasics {
	
	/* Day 1 – Strings Basics 
	 * Challenge: Write functions to reverse a string, count vowels/consonants, and check for palindromes.
	 * Objectives: String manipulation, functions, input/output.
	 * Success Criteria: Correct outputs with varied test cases.
	 * Time: 1.5 hrs.
	 */
	
	public static String reversedString(String word) {
		String reversed = "";
		
		for(int i = word.length() - 1; i >= 0; i--) {
			reversed += word.charAt(i);
		}
		
		return reversed;
	}
	
	public static int countConsonant(String word) {
		int count = 0;
		
		for (int i = 0; i < word.length(); i++) {
			char letter = word.toUpperCase().charAt(i);
		
			if(letter != 'A' && letter != 'E' && letter != 'I' && letter != 'O' && letter != 'U') {
				count++;
			}
		}
		
		return count;
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
	
//	This palindrome needs to improve
//	need to achieve is to A man, a plan, a canal – Panama
	public static boolean isPalindrome(String word) {
		return word.equalsIgnoreCase(reversedString(word));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Type a word: ");
		String word = scanner.nextLine();
		
		System.out.println("Count Vowels: " + countVowels(word));
		System.out.println("Count Consonant: " + countConsonant(word));
		System.out.println("Reversed String: " + reversedString(word));
		System.out.println("Is Palindrome?: " + isPalindrome(word));	
		
		
		
		scanner.close();
	}
}
