package challenge.day6;

import java.util.ArrayList;

public class ControlStructuresLoops {
	
	/* Day 6 – Control Structures: Loops
	 * Challenge: Generate multiplication tables, Fibonacci sequence, and prime numbers ≤ 100.
	 * Objectives: For-loop, while-loop, nested loops.
	 * Pitfall Warning: Infinite loops! Always check loop termination.
	 */
	
	public static void generateMultiplicationTable(int count) {
		for(int i = 1; i < count + 1; i++) {
			for(int j = 0; j <= 10; j++) {
				int result = i * j;
				System.out.println(i + " x " + j + " = " + result);
			}
			System.out.println("");
		}
	}
	
	//0, 1, 1, 2, 3, 5 - this are the example of a Fibonnaci Sequence
	public static void fibonacciSequence() {
		int next = 0;
		int prev = 0;
		int current = 0;
		
		ArrayList<Integer> fs = new ArrayList<Integer>();
		
		for(int i = 0; i < 10 - 1; i++) {			
			fs.add(current);
			
			if(current == 0) {
				current = i + (i+1);
				prev = i + 1;
				fs.add(prev);
				fs.add(current);
			}
			
			next = prev + current;
			prev = current;
			current = next;
		}
		fs.add(current);		
		System.out.println(fs);
	}
	
	//2, 3, 5, 7, 11, 13, 17, 19, 23, 29 - this are the examples of Prime Numbers
	public static void primeNumbers() {
		ArrayList<Integer> pN = new ArrayList<Integer>();
		boolean isPrime = false;
		for(int i = 2; i <= 9; i++) {
			if(i == 2 || i == 3) {
				pN.add(i);
				continue;
			}
			int rootValue = i / 2;
			for(int j = 2; j <= rootValue; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}else {
					isPrime = true;
				}
			}
			if(isPrime) {
				pN.add(i);
			}
		}
		
		System.out.println(pN);
	}

	public static void main(String[] args) {
		generateMultiplicationTable(10);
		fibonacciSequence();
		primeNumbers();		
	}
}
