/*
 * https://www.hackerearth.com/practice/basic-programming/operators/basics-of-operators/practice-problems/algorithm/let-us-understand-computer-78476e7a/
 * */
package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetUsUnderstandComputer {

	public static void main(String[] args) throws Exception {
		try {
			FastReader br = new FastReader();
			int T = br.nextInt();
			for (int i = 0; i < T; i++) {
				long count = 0;
				long X = br.nextLong();
				for (long j = 1; j <= X; j++) {
					long q1 = X / j;
					long lq = Long.toBinaryString(q1).length();
					long ld = Long.toBinaryString(j).length();
					if (lq <= ld) {
						count++;
					}
					// System.out.printf("D=%d(%d bit), result = %d/%d=%d (%d bits)\n", j,ld,X,j,(X/j),lq);
				}
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
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