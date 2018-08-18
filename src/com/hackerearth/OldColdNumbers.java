package com.hackerearth;

/*
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/old-and-cold-numbers-d9326e6b/
 * */

import java.util.Scanner;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class OldColdNumbers {
	static int countOld, countCold, queryNumber, arraySize;
	static int[] originalArray, queryRange;

	public static void main(String args[]) throws Exception {
		long startTime = System.nanoTime();
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 0; t < T; t++) {
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
		}
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
				int count = 0;
				while (countOld < countCold) {
					countOld++;
					countCold--;
					count++;
				}
				System.out.println(count);
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
}
