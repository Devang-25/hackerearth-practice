package com.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */
/*
 * https://www.hackerearth.com/practice/basic-programming/operators/basics-of-operators/practice-problems/algorithm/birthday-party-12/
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BirthdayParty {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(M % N == 0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}
