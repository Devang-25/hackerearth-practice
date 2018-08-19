package com.hackerearth;

/*
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/print-hackerearth/
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Printhackerearth {
	public static void main(String[] args) throws Exception {
		Map<Character, Integer> freq = new TreeMap<Character, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if (c == 'h' || c == 'a' || c == 'c' || c == 'k' || c == 'e' || c == 'r' || c == 't') {
				if (freq.containsKey(c)) {
					freq.put(c, freq.get(c) + 1);
				} else {
					freq.put(c, 1);
				}
			}
		}
		for (Map.Entry<Character, Integer> es : freq.entrySet()) {
			char c = es.getKey();
			if (c == 'h' || c == 'a' || c == 'e' || c == 'r') {
				int count = es.getValue();
				if (freq.containsKey(c)) {
					freq.put(c, count / 2);
				}
			}
		}
		Collection<Integer> col = freq.values();
		int minVal = Collections.min(col);
		System.out.println(minVal);
	}
}
