package challenge.day7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberSystemConversions {
	
	/* Day 7 – Number System Conversions
	 * Challenge: Build functions for Binary ↔ Decimal ↔ Octal ↔ Hex conversions.
	 * Objectives: Division/remainder logic, string parsing.
	 * Milestone Checkpoint #2: Comfortable with data, control structures, and number systems.
	 */
	
	static ArrayList<Integer> storeNumbers(String num){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < num.length(); i++) {
			numbers.add(num.charAt(i) - '0');
		}
		
		return numbers;
	}
	
	static ArrayList<Integer> storeNumbers(String num, boolean isHalf){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int count = num.length() % 3;
		
		if(isHalf && count != 0) {
			for(int i = 0; i <= count; i++) {
				numbers.add(0);
			}
		}
		
		for(int i = 0; i < num.length(); i++) {
			numbers.add(num.charAt(i) - '0');
		}
		
		return numbers;
	}
	
	static String reverse(String val) {
		String reverseVal = "";
		
		for(int i = val.length() - 1; i >= 0; i--) {
			reverseVal += val.charAt(i);
		}
		
		return reverseVal;
	}
	
	static char hexLetters(int num) {
		HashMap<Integer, Character> letters = new HashMap<Integer, Character>();
		letters.put(10, 'A');
		letters.put(11, 'B');
		letters.put(12, 'C');
		letters.put(13, 'D');
		letters.put(14, 'E');
		letters.put(15, 'F');
		
		return letters.get(num);
	}
	
	static int hexNumbers(char letter) {
		HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
		letters.put('A', 10);
		letters.put('B', 11);
		letters.put('C', 12);
		letters.put('D', 13);
		letters.put('E', 14);
		letters.put('F', 15);
		
		return letters.get(letter);
	}
	
//	BINARY CONVERSION
	static String  binaryConversion(String binaryValue, int base) {
		ArrayList<Integer> numbers = storeNumbers(binaryValue, true);
		
		String retVal = "";
		int result = 0;
		int pow = 0;
		for(int i = numbers.size() - 1; i >= 0; i--) {
			double powerResult = Math.pow(2, pow); 
			result += powerResult * numbers.get(i);
			pow+=1;

			if(base == 8) {
				if(pow >= 3) {
					retVal += Integer.toString(result);
					pow = 0;
					result = 0;
				}				
			}else if(base == 16) {
				if(pow >= 4) {
					if(result >= 10) {
						retVal += hexLetters(result);					
					}else {
						retVal += result;
					}
					pow = 0;
					result = 0;
				}
			}
		}
		
		return base == 10 ? Integer.toString(result) : reverse(retVal);
	}
	
	static String binaryToDecimal(String binaryValue) {
		return binaryConversion(binaryValue, 10);
	}
	
	static String binaryToOctal(String binaryValue) {
		return binaryConversion(binaryValue, 8);
	}
	
	static String binaryToHex(String binaryValue) {
		return binaryConversion(binaryValue, 16);
	}
	
//	DECIMAL CONVERSION
	static String decimalConversion(int decimalValue, int base) {
		double current = decimalValue;
		String result = "";
		double remainder = 0;
		
		while(true) {
			remainder = current % base;
			current = current / base;
			
			if(remainder >= 10) {
				result += hexLetters((int)remainder);
			}else {				
				result += (int)remainder;
			}
			
			int isZero = (int)current;
			if(isZero == 0) {
				break;
			}
		}
		
		return reverse(result);
	}
	
	static String decimalToBinary(int decimalValue) {
		return decimalConversion(decimalValue, 2);
	}
	
	static String decimalToOctal(int decimalValue) {
		return decimalConversion(decimalValue, 8);
	}
	
	static String decimalToHexa(int decimalValue) {
		return decimalConversion(decimalValue, 16);
	}
	
//	OCTAL CONVERSION
	static String octalToBinary(String octalValue) {
		int result = octalToDecimal(octalValue);
		return decimalToBinary(result);
	}
	
	static int octalToDecimal(String octalValue) {
		ArrayList<Integer> numbers = storeNumbers(octalValue);
	
		int computeAll = 0;
		int powCount = 0;
		for(int i = numbers.size() - 1; i >= 0 ; i--) {
			double calculateBase = Math.pow(8, powCount);
			computeAll += calculateBase * numbers.get(i);
			powCount+=1;
		}
		
		return computeAll;
	}
	
	static String octalToHexa(String pVal) {
		int result = octalToDecimal(pVal);
		return decimalToHexa(result);
	}
	
//	HEXADECIMAL CONVERSION
	static String hexaToBinary(String hexaValue) {
		HashMap<String, String> value = new HashMap<String, String>();
		value.put("0", "0000");
		value.put("1", "0001");
		value.put("2", "0010");
		value.put("3", "0011");
		value.put("4", "0100");
		value.put("5", "0101");
		value.put("6", "0110");
		value.put("7", "0111");
		value.put("8", "1000");
		value.put("9", "1001");
		value.put("A", "1010");
		value.put("B", "1011");
		value.put("C", "1100");
		value.put("D", "1101");
		value.put("E", "1110");
		value.put("F", "1111");
		
		String converted = "";
		for(int i = 0; i < hexaValue.length(); i++) {
			converted += value.get(String.valueOf(hexaValue.charAt(i)));
		}
		
		return converted;
	}
	
	static String hexaToDecimal(String hexaValue) {
		int total = 0;
		int pow = 0;
		for(int i = hexaValue.length() - 1; i >= 0 ; i--) {
			double baseResult = Math.pow(16, pow);
			int hexa = 0;
			if(Character.isDigit(hexaValue.charAt(i))) {
				String toStringHexa = Character.toString(hexaValue.charAt(i));
				hexa = Integer.parseInt(toStringHexa);
			}else {
				hexa = hexNumbers(hexaValue.charAt(i));				
			}
			
			double hexaTotal = hexa * baseResult;
			
			total += (int)hexaTotal;
			pow += 1;
		}

		return Integer.toString(total);
	}
	
	static String hexaToOctal(String hexaValue) {
		String result = hexaToBinary(hexaValue);
		return binaryToOctal(result);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("***BINARY CONVERSION***");
		System.out.println("Binary to Decimal ............. 1");
		System.out.println("Binary to Octal ............... 2");
		System.out.println("Binary to HexaDecimal ......... 3");
		System.out.println("\n***DECIMAL CONVERSION***");
		System.out.println("Decimal to Binary ............. 4");
		System.out.println("Decimal to Octal .............. 5");
		System.out.println("Decimal to HexaDecimal ........ 6");
		System.out.println("\n***OCTAL CONVERSION***");
		System.out.println("Octal to Binary ............... 7");
		System.out.println("Octal to Decimal .............. 8");
		System.out.println("Octal to HexaDecimal .......... 9");
		System.out.println("\n***HEXADECIMAL CONVERSION***");
		System.out.println("HexaDecimal to Binary ......... 10");
		System.out.println("HexaDecimal to Decimal ........ 11");
		System.out.println("HexaDecimal to Octal .......... 12");
		System.out.print("\nType your choices: ");
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				System.out.print("Write a binary to convert into decimal: ");
				String binary1 = scanner.next();
				System.out.println(binaryToDecimal(binary1));
				break;
			case 2:
				System.out.print("Write a binary to convert into octal: ");
				String binary2 = scanner.next();
				System.out.println(binaryToOctal(binary2)); 
				break;
			case 3:
				System.out.print("Write a binary to convert into hex: ");
				String binary3 = scanner.next();
				System.out.println(binaryToHex(binary3)); 
				break;
			case 4:
				System.out.print("Write a decimal to convert into binary: ");
				int decimal1 = scanner.nextInt();
				System.out.println(decimalToBinary(decimal1)); 
				break;
			case 5:
				System.out.print("Write a decimal to convert into octal: ");
				int decimal2 = scanner.nextInt();
				System.out.println(decimalToOctal(decimal2));
				break;
			case 6:
				System.out.print("Write a decimal to convert into hexa: ");
				int decimal3 = scanner.nextInt();
				System.out.println(decimalToHexa(decimal3)); 
				break;
			case 7:
				System.out.print("Write a octal to convert into binary: ");
				String octal1 = scanner.next();
				System.out.println(octalToBinary(octal1)); 
				break;
			case 8:
				System.out.print("Write a octal to convert into decimal: ");
				String octal2 = scanner.next();
				System.out.println(octalToDecimal(octal2)); 
				break;
			case 9:
				System.out.print("Write a octal to convert into hexa: ");
				String octal3 = scanner.next();
				System.out.println(octalToHexa(octal3)); 
				break;
			case 10:
				System.out.print("Write a hexa to convert into binary: ");
				String hexa1 = scanner.next();
				System.out.println(hexaToBinary(hexa1)); 
				break;
			case 11:
				System.out.print("Write a hexa to convert into decimal: ");
				String hexa2 = scanner.next();
				System.out.println(hexaToDecimal(hexa2)); 		
				break;
			case 12:
				System.out.print("Write a hexa to convert into octal: ");
				String hexa3 = scanner.next();
				System.out.println(hexaToOctal(hexa3));
				break;
			default:
				System.out.println("Invalid Input!");
		}

		scanner.close();
	}
}
