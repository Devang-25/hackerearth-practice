package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int factorial = 1;
		for (int i = 1; i <= N; i++) {
			factorial*=i;
		}
		System.out.println(factorial);
	}

}
