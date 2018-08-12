package com.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class OldColdNumbers {
	static int countOld, countCold, queryNumber, arraySize;
	static int[] originalArray, queryRange;

	public static void main(String args[]) throws Exception {
		long startTime = System.nanoTime();
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 * 
		 */

		// Scanner
		Scanner s = new Scanner(System.in);
		@SuppressWarnings("unused")
		int testCase = s.nextInt();
		arraySize = s.nextInt();
		originalArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			originalArray[i] = s.nextInt();
		}
		queryNumber = s.nextInt();
		queryRange = new int[queryNumber * 2];
		for (int i = 0; i < queryNumber * 2; i++) {
			queryRange[i] = s.nextInt();
		}

		perform();	
		s.close();
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime + " nano seconds");
	}

	public static void perform() {
		for (int i = 0; i < queryNumber * 2; i++) {
			int L = queryRange[i] - 1;
			int U = queryRange[i + 1];
			int[] arrayDuplicate = new int[U - L];
			int a = 0;
			for (int j = L; j < U; j++) {
				arrayDuplicate[a] = originalArray[j];
				a++;
			}
			i++;
			countOldCold(arrayDuplicate);
			if (countOld >= countCold)
				System.out.println(0);
			else {
				System.out.println("TO DO");
				// performQuery();
			}

		}
	}

	public static void countOldCold(int[] arrayDuplicate) {
		countOld = 0;
		countCold = 0;
		for (int a : arrayDuplicate) {
			if (checkOld(a)) {
				countOld++;
			} else
				countCold++;
		}
	}

	public static boolean checkOld(int a) {
		if (a % 2 == 0)
			if (a % (a / 2) == 0)
				return true;

		if (a % 2 != 0)
			if (a % ((a / 2) + 1) == 0)
				return true;

		return false;

	}

	public static void performQuery() {

	}
}
