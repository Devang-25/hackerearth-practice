package com.hackerearth;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BinaryMatrix {
	static int M, N, row = -1;
	static String[][] matrix;

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 */
		// Scanner
		Scanner s = new Scanner(System.in);
		double max = -1;
		M = s.nextInt();
		N = s.nextInt();
		matrix = new String[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = s.next();
			}
		}
		int power = 0;
		for (int i = 0; i < M; i++) {
			double a = 0;
			power = 0;
			for (int j = N - 1; j >= 0; j--) {
				a = a + Math.pow(2, power) * Integer.valueOf(matrix[i][j]);
				power++;
			}
			// System.out.println(a);
			if (max < a) {
				max = a;
				row = i;
			}
		}
		// System.out.println(max);
		System.out.println(row + 1);
		s.close();
	}
}
