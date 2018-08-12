package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cipher {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int l = S.length();
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < l; i++) {
			char c = S.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				int rem = N % 26;
				char c1 = ' ';
				int total = c + rem;
				if (total <= 'Z') {
					c1 = (char) total;
				} else {
					int k = (int) (total - 'Z' + 'A' - 1);
					c1 = (char) k;
				}
				code.append(c1);
			} else if (c >= 'a' && c <= 'z') {
				int rem = N % 26;
				char c1 = ' ';
				int total = c + rem;
				if (total <= 'z') {
					c1 = (char) total;
				} else {
					int k = (int) (total - 'z' + 'a' - 1);
					c1 = (char) k;
				}
				code.append(c1);
			} else if (c >= '0' && c <= '9') {
				int rem = N % 10;
				char c1 = ' ';
				int total = c + rem;
				if (total <= '9') {
					c1 = (char) total;
				} else {
					int k = (int) (total - '9' + '0' - 1);
					c1 = (char) k;
				}
				code.append(c1);
			} else {
				code.append(c);
			}
		}
		System.out.println(code);
	}

}