package com.hackerearth;

/*
 https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoyandProfilePicture {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] W = new int[N];
		int[] H = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			if (L > W[i] || L > H[i])
				System.out.println("UPLOAD ANOTHER");
			else if (W[i] >= L && H[i] >= L) {
				if (W[i] == H[i])
					System.out.println("ACCEPTED");
				else
					System.out.println("CROP IT");
			}
		}

	}

}
