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

class EvenLengthPalindromeNumber {
	public static void main(String args[]) throws Exception {

		// long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		List<Long> inputList = new ArrayList<Long>();
		Scanner sc = new Scanner(System.in);
		// System.out.println("First line contains T, number of test cases : ");
		int T = sc.nextInt();
		// System.out.println("Each of the next T lines contains an integer N : ");
		for (int i = 0; i < T; i++) {
			// System.out.println("Enter value : ");
			long val = sc.nextLong();
			inputList.add(val);
		}

		Iterator<Long> itr = inputList.iterator();
		while (itr.hasNext()) {
			long val = itr.next();
			System.out.println(getMaxOfX(val));
		}

		// long stopTime = System.currentTimeMillis();
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime + " nano seconds");
		sc.close();
	}

	public static long getMaxOfX(final long val) {
		long inputNumber = val;
		Map<Long, Long> digitCountMap = new HashMap<Long, Long>();

		while (inputNumber != 0) {
			long lastDigit = inputNumber % 10L;
			if (digitCountMap.containsKey(lastDigit)) {
				digitCountMap.put(lastDigit, digitCountMap.get(lastDigit) + 1L);
			} else {
				digitCountMap.put(lastDigit, 1L);
			}
			inputNumber = inputNumber / 10L;
		}
		if (digitCountMap.size() == 1) {
			Set<Long> set = digitCountMap.keySet();
			Iterator<Long> itr = set.iterator();
			while (itr.hasNext()) {
				return itr.next();
			}
		} else if (digitCountMap.size() > 1) {
			Collection<Long> values = digitCountMap.values();
			long maxFrequency = Collections.max(values);
			Long minKeyValue = Long.MAX_VALUE;
			for (Map.Entry<Long, Long> mapEntry : digitCountMap.entrySet()) {
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
