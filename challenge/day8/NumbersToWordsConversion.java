package challenge.day8;

import java.util.Scanner;
import java.util.HashMap;
import java.text.DecimalFormat;

public class NumbersToWordsConversion {
	
	/* Day 8 – Numbers → Words Conversion
	 * Challenge: Convert an integer (up to trillions) into English words. 
	   Example input: 1,250,230,321,900 → One Trillion Two Hundred Fifty Billion 
	   Two Hundred Thirty Million Three Hundred Twenty-One Thousand Nine Hundred.
	 * Objectives: Large-number grouping (thousands, millions, billions, trillions),
	   handling zero, proper grammar.
	 * Success Criteria: Correct English-word representation for edge cases: 0, 11–19,
	   hundreds with zeros (e.g., 100, 1,000,010).
	 * Hints: Break number into groups of three digits (units, thousands, millions, ...),
	   convert each group, then append scale words.
	 */
	
	// 1,250,230,321,900
	// 64748456
	
	static HashMap<Integer, String> groupNumber = new HashMap<>();
	static HashMap<Integer, String> numberWord = new HashMap<>();
	
	static final String TEEN_TEXT = "teen";
	static final String TY_TEXT = "ty";
	static final String HUNDRED_TEXT = "hundred";
	
	static final int ZERO = 0;
	static final int HUNDRED = 100;
	static final int TEN = 10;
	static final int TWENTY = 20;
	
	static void initializeWord() {
		groupNumber.put(2, "Thousand");
		groupNumber.put(3, "Million");
		groupNumber.put(4, "Billion");
		groupNumber.put(5, "Trillion");
		
		numberWord.put(1, "One");
		numberWord.put(2, "Two");
		numberWord.put(3, "Three");
		numberWord.put(4, "Four");
		numberWord.put(5, "Five");
		numberWord.put(6, "Six");
		numberWord.put(7, "Seven");
		numberWord.put(8, "Eight");
		numberWord.put(9, "Nine");
		numberWord.put(10, "Ten");
		numberWord.put(11, "Eleven");
		numberWord.put(12, "Twelve");
		numberWord.put(13, "Thirteen");
		numberWord.put(15, "Fifteen");
		numberWord.put(20, "Twenty");
		numberWord.put(30, "Thirty");
		numberWord.put(50, "Fifty");
	}
	
	static String getMapValue(HashMap<Integer, String> map, int key, String defaultValue) {
		return map.containsKey(key) ? map.get(key) : defaultValue;
	}
	
	static String extract(int value, int groupPosition) {
		String retNumValue = "";
		int hundreds = value / HUNDRED;
		int remainder = value % HUNDRED;
		
		if(hundreds > ZERO) {
			retNumValue += " " + getMapValue(numberWord, hundreds, "") +" "+ HUNDRED_TEXT;
		}
		
		if(remainder > ZERO) {
			if(!numberWord.containsKey(remainder)) {
				if(remainder < TWENTY) {
					retNumValue += " " + getMapValue(numberWord, remainder - TEN, "") + TEEN_TEXT;
				}else {
					int tens = remainder / TEN;
					int tensRemainder = remainder % TEN;
				
					String notFoundDefaultValue = getMapValue(numberWord, tens, "")+TY_TEXT;
					System.out.println(notFoundDefaultValue);
					System.out.println(tens +" "+ remainder);
					retNumValue += String.format(" %s ", getMapValue(numberWord, (tens * TEN), notFoundDefaultValue));
					retNumValue +=  getMapValue(numberWord, tensRemainder, "");
				}
			}else {
				retNumValue +=  String.format(" %s", getMapValue(numberWord, remainder, ""));
			}
		}
		
		return String.format("%s %s", retNumValue, getMapValue(groupNumber, groupPosition, ""));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		initializeWord();

		System.out.print("Write a number: ");
		double number = in.nextDouble();
		
		DecimalFormat formatter = new DecimalFormat("#,###");
		String formattedNumber = formatter.format(number);
		String[] splitNumber = formattedNumber.split(",");
		
		System.out.println(formattedNumber);
		
		String mergeText = "";
		int groupPosition = splitNumber.length;
		for(String getGroupNumber : splitNumber) {
			int parseNumber = Integer.parseInt(getGroupNumber);
			if(parseNumber == 0) {
				groupPosition--;
				continue;
			}
			mergeText += extract(parseNumber, groupPosition);
			groupPosition--;
		}
		
		System.out.println(mergeText);
		
		in.close();
	}
}
