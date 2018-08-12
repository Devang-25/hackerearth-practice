package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ToggleString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char s[] = br.readLine().toCharArray();
		for (char c : s) {
			if (c >= 'A' && c <= 'Z') {
				System.out.print((char) (c + 32));
			} else if (c >= 'a' && c <= 'z') {
				System.out.print((char) (c - 32));
			}
		}
	}

}
