package com.hackerearth;

/*
 https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/play-with-numbers-2/
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PlayWithNumbers {

	public static void main(String[] args) throws Exception {
		FastReader fr = new FastReader();
		int N = fr.nextInt();
		int Q = fr.nextInt();
		List<Long> arr = new ArrayList<Long>();
		arr.add(fr.nextLong());
		for (int i = 1; i < N; i++) {
			arr.add(arr.get(i - 1) + fr.nextLong());
		}
		for (int i = 0; i < Q; i++) {
			int lower = fr.nextInt() - 1;
			int upper = fr.nextInt() - 1;
			int count = upper - lower + 1;
			long total = 0;
			if(lower == 0)
				total = arr.get(upper);
			else
				total = arr.get(upper) - arr.get(lower - 1);
			
			System.out.println((long) (total / count));
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
