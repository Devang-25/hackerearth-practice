package com.hackerearth;

/*
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/psychic-powers/
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LittleJhoolAndPsychicPowers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char prev = ' ';
		boolean isBad = false;
		int count0 = 0,count1 = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			prev = c;
			if(prev == c && c == '0') {
				count1 = 0;
				count0++;
				if(count0 == 6) {
					isBad = true;
					break;
				}
			}
			if(prev == c && c == '1') {
				count0 = 0;
				count1++;
				if(count1 == 6) {
					isBad = true;
					break;
				}
			}
		}
		System.out.println(isBad ? "Sorry, sorry!" : "Good luck!");
	}
}
