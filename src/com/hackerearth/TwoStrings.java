package com.hackerearth;
/*
 https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/two-strings-4/
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TwoStrings {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s1[] = new String[T];
		String s2[] = new String[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			s1[i] = tk.nextToken();
			s2[i] = tk.nextToken();
		}
		for (int i = 0; i < T; i++) {
			List<Character> al1 = new ArrayList<Character>();
			List<Character> al2 = new ArrayList<Character>();
			for(int j = 0; j<s1[i].length(); j++) {
				al1.add(s1[i].charAt(j));
				al2.add(s2[i].charAt(j));
			}
			Collections.sort(al1);
			Collections.sort(al2);
			if(al1.equals(al2))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
