package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountDivisors {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (i % k == 0)
				count++;
		}
		System.out.println(count);
	}

}
