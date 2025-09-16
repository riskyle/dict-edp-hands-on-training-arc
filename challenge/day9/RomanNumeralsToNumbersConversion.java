package challenge.day9;

import java.util.Scanner;
import java.util.HashMap;

public class RomanNumeralsToNumbersConversion {
	
	/* Day 9 – Roman Numerals <> Numbers Conversion
	 * Challenge: Convert Roman numerals (e.g., MCMXCIV) to integers and validate correct Roman format.
	 * Objectives: Pattern matching, subtraction rule (IV = 4, IX = 9), validation of repeats and order.
	 * Success Criteria: Correctly parse standard Roman numerals up to at least 3,999.
	 */
	
	static int romanToNumberConversion(String romanLetters) {
		HashMap<Character, Integer> romans = new HashMap<>();
		romans.put('I', 1);
		romans.put('V', 5);
		romans.put('X', 10);
		romans.put('L', 50);
		romans.put('C', 100);
		romans.put('D', 500);
		romans.put('M', 1000);
		
		int result = 0;
		
		for(int i = 0; i < romanLetters.length(); i++) {
			System.out.println(i);
			if(i != romanLetters.length() - 1 && romans.get(romanLetters.charAt(i)) < romans.get(romanLetters.charAt(i + 1))) {
				result -= romans.get(romanLetters.charAt(i));
			}else {
				result += romans.get(romanLetters.charAt(i));
			}
		}
		
		return result;
	}
	
	static String numberToRomanConversion(int number) {
		Object[][] symlist = {
				{"I", 1}, {"IV", 4}, {"V", 5}, {"IX", 9},
				{"X", 10}, {"XL", 40}, {"L", 50}, {"XC", 90},
				{"C", 100}, {"CD", 400}, {"D", 500}, {"CM", 900},
				{"M", 1000}
		};
		
		String result = "";
		
		for(int i = symlist.length - 1; i >= 0; i--) {
			String sym = symlist[i][0].toString();
			String val = symlist[i][1].toString();
			
			int count = Math.floorDiv(number, Integer.parseInt(val));
			
			if(count == 0) {
				continue;
			}
			
			for(int j = 0; j < count; j++) {
				result += sym;
			}
			
			number %= Integer.parseInt(val);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Write a number: ");
		int number = in.nextInt();
		
		System.out.println(numberToRomanConversion(number));
		System.out.println(romanToNumberConversion(numberToRomanConversion(number)));
		
		in.close();
	}

}
