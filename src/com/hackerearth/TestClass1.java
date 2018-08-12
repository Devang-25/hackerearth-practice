package com.hackerearth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class TestClass1 {
	public static void main(String args[]) throws Exception {

		long startTime = System.currentTimeMillis();
		List<Integer> inputList = new ArrayList<Integer>();
		List<Integer> evenLengthPalindromeNumbers = new ArrayList<Integer>();
		List<Integer> requiredPalindromeNumbers = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// System.out.println("First line contains T, number of test cases : ");
		int T = sc.nextInt();
		// System.out.println("Each of the next T lines contains an integer N : ");
		for (int i = 0; i < T; i++) {
			// System.out.println("Enter value : ");
			int val = sc.nextInt();
			inputList.add(val);
		}
		Collections.sort(inputList);

		evenLengthPalindromeNumbers = getEvenLengthPalindromeNumbers(inputList.get(inputList.size() - 1));
		// System.out.println(evenLengthPalindromeNumbers);
		requiredPalindromeNumbers = getRequiredPalindromeNumbers(inputList, evenLengthPalindromeNumbers);
		// System.out.println(requiredPalindromeNumbers);
		printOutputX(requiredPalindromeNumbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime/1000 + " seconds");
		sc.close();

	}

	public static List<Integer> getEvenLengthPalindromeNumbers(final int a) {

		List<Integer> l = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0;; i++) {
			String s = String.valueOf(i);
			if (s.length() % 2 == 0 && checkPalindromeNumber(s)) {
				count++;
				l.add(i);
				if (count == a)
					break;
			}
		}

		return l;
	}

	public static boolean checkPalindromeNumber(final String S) {
		int flg = 0;
		for (int i = 0; i < S.length() / 2; i++) {

			if (S.charAt(i) != S.charAt(S.length() - i - 1)) {
				flg = 1;
				return false;
			}
		}

		if (flg == 0)
			return true;

		return false;
	}

	public static List<Integer> getRequiredPalindromeNumbers(final List<Integer> inputList,
			final List<Integer> evenLengthPalindromeNumbers) {
		List<Integer> requiredPalindromeNumbers = new ArrayList<Integer>();
		Iterator<Integer> itr = inputList.iterator();
		while (itr.hasNext()) {
			int val = (int) itr.next();
			requiredPalindromeNumbers.add(evenLengthPalindromeNumbers.get(val - 1));
		}
		return requiredPalindromeNumbers;
	}

	public static void printOutputX(final List<Integer> requiredPalindromeNumbers) {
		Iterator<Integer> itr = requiredPalindromeNumbers.iterator();
		while (itr.hasNext()) {
			int val = (int) itr.next();
			// System.out.println(val);
			// getMaxOfX(val);
			System.out.println(getMaxOfX(val));
		}
	}

	public static int getMaxOfX(final int val) {
		int inputNumber = val;
		HashMap<Integer, Integer> digitCountMap = new HashMap<Integer, Integer>();

		while (inputNumber != 0) {
			int lastDigit = inputNumber % 10;
			if (digitCountMap.containsKey(lastDigit)) {
				digitCountMap.put(lastDigit, digitCountMap.get(lastDigit) + 1);
			} else {
				digitCountMap.put(lastDigit, 1);
			}
			inputNumber = inputNumber / 10;
		}
		if (digitCountMap.size() == 1) {
			Set<Integer> set = digitCountMap.keySet();
			Iterator<Integer> itr = set.iterator();
			while (itr.hasNext()) {
				int temp = itr.next();
				// System.out.println(temp);
				return temp;
			}
		} else if (digitCountMap.size() > 1) {
			Collection<Integer> values = digitCountMap.values();
			long maxFrequency = Collections.max(values);
			Integer minKeyValue = Integer.MAX_VALUE;
			for (Map.Entry<Integer, Integer> mapEntry : digitCountMap.entrySet()) {
				if (mapEntry.getValue() == maxFrequency) {
					if (mapEntry.getKey() < minKeyValue) {
						minKeyValue = mapEntry.getKey();
					}
				}

			}
			return minKeyValue;
		}

		return 0;

	}
}
