package com.hackerearth;

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class PrimeNumber {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count;
		int N = Integer.parseInt(br.readLine());
		if(N > 1) {
			System.out.print(2 + " ");
		}
		for (int i = 3; i <= N; i+=2) {
			count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
				if (count > 2)
					break;
			}
			if(count == 2)
				System.out.print(i + " ");
		}
	}
}
