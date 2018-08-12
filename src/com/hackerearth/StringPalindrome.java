package com.hackerearth;
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class StringPalindrome {
	public static void main(String args[]) throws Exception {
		boolean isPalindrome = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int l = name.length();
		for (int i = 0; i < l / 2; i++) {
			if (name.charAt(i) != name.charAt(l - i - 1)) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
