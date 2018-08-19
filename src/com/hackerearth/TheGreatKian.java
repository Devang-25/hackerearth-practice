package com.hackerearth;

/*
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-great-kian/
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheGreatKian {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		long s1 = 0;
		for (int i = 0; i < N; i += 3) {
			s1 += A[i];
		}
		System.out.print(s1 + " ");
		long s2 = 0;
		for (int i = 1; i < N; i += 3) {
			s2 += A[i];
		}
		System.out.print(s2 + " ");
		long s3 = 0;
		for (int i = 2; i < N; i += 3) {
			s3 += A[i];
		}
		System.out.print(s3);

	}
}
