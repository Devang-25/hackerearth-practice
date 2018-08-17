package com.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */
/*
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MagicalWord {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String S = br.readLine();
            solve(N, S);
        }

    }

    public static void solve(int N, String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = S.codePointAt(i);
            int next = temp;
            int prev = temp;
            if (next >= 122) {
                next = 113;
            }
            if (prev <= 65) {
                prev = 67;
            }
            while (!isPrime(next) && !isPrime(prev)) {
                next++;
                prev--;
                if (next >= 122) {
                    next = 113;
                }
                if (prev <= 65) {
                    prev = 67;
                }
            }
            if (isPrime(next) && isPrime(prev))
                sb.append((char) prev);
            else if (isPrime(next))
                sb.append((char) next);
            else if (isPrime(prev))
                sb.append((char) prev);
        }
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int a) {
        int count = 0;
        boolean isPrime = false;
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                count++;
                if (count > 1) {
                    break;
                }
            }
        }
        if (count == 1) isPrime = true;

        return isPrime;
    }
}
