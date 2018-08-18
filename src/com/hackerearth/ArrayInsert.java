package com.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */
/*
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/array-insert/
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class ArrayInsert {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
		}
		for (int i = 0; i < Q; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st2.nextToken());
			if (type == 1) {
				int index = Integer.parseInt(st2.nextToken());
				int update = Integer.parseInt(st2.nextToken());
				A[index] = update;
			} else if (type == 2) {
				int L = Integer.parseInt(st2.nextToken());
				int R = Integer.parseInt(st2.nextToken());
				long sum = -1;
				if (L >= 0 && R <= (A.length - 1)) {
					sum = 0;
					for(int j = L; j <= R; j++){
						sum+=A[j];
					}
					System.out.println(sum);
				} else
					System.out.println(sum);
			}
		}
	}
}
