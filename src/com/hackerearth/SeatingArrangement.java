package com.hackerearth;
/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

/*NOT CORRECT*/
class SeatingArrangement {
	public static boolean isNear = false;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seat = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			seat[i] = Integer.parseInt(tk.nextToken());

		}
		for (int i = 0; i < N; i++) {
			String seatType = seatType(seat[i]);
			int oppositeSeat = oppositeSeat(seat[i], seatType);
			System.out.println(oppositeSeat + " " + seatType);
		}
	}

	public static String seatType(int i) {
		int temp = i % 12;
		if (temp == 1 || temp == 0) {
			isNear = true;
			return "WS";
		} else if (temp == 6 || temp == 7) {
			isNear = false;
			return "WS";
		} else if (temp == 2 || temp == 11) {
			isNear = true;
			return "MS";
		} else if (temp == 5 || temp == 8) {
			isNear = false;
			return "MS";
		} else if (temp == 3 || temp == 10) {
			isNear = true;
			return "AS";
		} else if (temp == 4 || temp == 9) {
			isNear = false;
			return "AS";
		}
		return " ";
	}

	public static int oppositeSeat(int i, String seatType) {
		int cons = 12;
		int temp = i / cons;
		int lowerRange = (temp - 1) * cons + 1;
		int upperRange = temp * cons;
		// System.out.println(lowerRange);
		// System.out.println(upperRange);
		double midRange = (double) ((lowerRange) + (upperRange)) / 2;
		// System.out.println(midRange);
		if (i > midRange && !isNear) {
			if (seatType == "WS") {
				return i - 1;
			} else if (seatType == "MS") {
				return i - 3;
			} else if (seatType == "AS") {
				return i - 5;
			}
		}  else if (i < midRange && !isNear) {
			if (seatType == "WS") {
				return i + 1;
			} else if (seatType == "MS") {
				return i + 3;
			} else if (seatType == "AS") {
				return i + 5;
			}
		} else if (i > midRange && isNear) {
			if (seatType == "WS") {
				return i - 11;
			} else if (seatType == "MS") {
				return i - 9;
			} else if (seatType == "AS") {
				return i - 7;
			}
		} else if (i < midRange && isNear) {
			if (seatType == "WS") {
				return i + 11;
			} else if (seatType == "MS") {
				return i + 9;
			} else if (seatType == "AS") {
				return i + 7;
			}
		}
		return 0;
	}
}
