package challenge.week1.day3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndValidation {
	
	/* Day 3 – Arrays & Validation
	 * Challenge: Take a list of numbers, validate input (no negatives), then calculate mean, median, mode.
	 * Objectives: Input validation, arrays, basic math ops.
	 * Success Criteria: Correct results for test arrays.
	 */
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int setIndexArray() {
		int indexOfAnArray = 0;
		
		while(true) {
			System.out.print("Index of an array: ");
			indexOfAnArray = scanner.nextInt();			
		
			if(!isNegativeInput(indexOfAnArray)) {
				break;
			}
		}
		
		return indexOfAnArray;
	}
	
	public static void setArrayNumbers(int arrSize, int[] arr, int i) {
		while(arrSize > 0) {
			System.out.print("Write a number: ");
			int number = scanner.nextInt();
			
			if(isNegativeInput(number)) {
				continue;
			}
			
			arrSize--;

			arr[i] = number;
			
			i++;
		}
	}
	
	public static boolean isNegativeInput(int num) {
		return num < 0;
	}
	
	public static int[] listOfNumbers() {
		int getIndex = setIndexArray();
		int[] arr = new int[getIndex];
		
		int arrSize = arr.length;
		setArrayNumbers(arrSize, arr, 0);

		Arrays.sort(arr);
		
		return arr;
	}
	
	public static int mean(int[] arr) {
		int total = 0;
		int length = arr.length;
		
		for(int i = 0; i < length; i++) {
			total += arr[i];
		}
		
		int result = Math.floorDiv(total, length);
		
		return result;
	}
	
	public static double median(int[] arr) {
		double median;
		if(arr.length % 2 == 0) {
			int rightMiddle = arr.length / 2;
			int leftMiddle = rightMiddle - 1;
			median = (arr[rightMiddle] + arr[leftMiddle]) / 2;
			return median;
		}else {
			int middle = arr.length / 2;
			median = arr[middle];
			return median;
		}
	}
	
	// mode instance for Most Often Data Entered
	public static ArrayList<Integer> mode(int[] arr) {	
		ArrayList<Integer> modes = new ArrayList<Integer>();
		
		int maxCount = 0;
		int count = 0;
		int cVal = 0; // current value
		
		for(int i = 0; i < arr.length; i++) {
			// check if the cVal is not equal to the iterated value
			if(cVal != arr[i]) { 
				// first we check if the iterated count has a higher value to the maxCount
				if(count > maxCount) {
					// if true so it will clear the stored modes and stored the value that has greater counts
					modes.clear();
					maxCount = count;
					modes.add(cVal);
				}else if(count == maxCount){ // check if the iterated count has the same counts on maxCount so 
											// if true add the value to the modes array
					modes.add(cVal);
				}
								
				count = 0; // because the cVal had a new value so we now reset the count to 0
				cVal = arr[i]; // passed the new iterated value to cVal
				count+=1; 
			}else {
				count+=1;
			}			
		}
		
//		check if the last iterated count has the greater value on maxCount
//		if true clear modes array to store the higher count value
		if(count > maxCount) {
			modes.clear();
			maxCount = count;
			modes.add(cVal);
		}else if(count == maxCount) { // if still has the same count on the maxCount just add it to the modes array
			maxCount = count;
			modes.add(cVal);
		}
		
		return modes;
	}

	public static void main(String[] args) {
		int[] arr = listOfNumbers();
				
		System.out.println(Arrays.toString(arr));
		System.out.println("Mean Result: " + mean(arr));
		System.out.println("Median Result: " + median(arr));
		System.out.println("Mode Result: " + mode(arr));
		
		scanner.close();
	}

}
