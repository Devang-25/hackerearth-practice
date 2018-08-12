package com.hackerearth;
/*Leaderboard Standings
There were  submissions made in a programming contest containing infinite problems. Each submission earned the contestant  points as none of the submissions is a wrong or a partial submission. You are given the details of the submissions - the username of the contestant and the time taken to solve the problem. Your task is to print the rank list according to the following rules:

The contestant with a higher score gets a higher rank.
If the scores are tied, then the contestant with the least sum of the time taken to solve the problems gets a higher rank.
In case of a tie in both scores and sum of the time taken, they are ranked lexicographically according to their usernames. 
Note: The details of the submissions are not sorted in any order (neither by time nor by username)

INPUT FORMAT

The first line of every test file contains an integer , the number of submissions.  lines follow, each being the details of th submission. 

Each of the  lines contains a string , the username of the contestant corresponding to  submission, and an integer , the time of submission in minutes, separated by a space.

OUTPUT FORMAT

Output the rank of the contestant and the username, in the increasing order of the ranks. Each rank should be displayed in a newline.

CONSTRAINTS


 where  denotes the length of the string s


Number of unique usernames are at most 

Sample Input
9
Tom 6
Jim 7
Tom 19
Phil 8
Rick 12
Jim 22
Rick 18
Phil 22
Tom 36

Sample Output
1 Tom
2 Jim
3 Phil
4 Rick

Explanation
Tom stands 1st with 300 points since no other contestant scored 300. Jim stands 2nd as he has solved the problems in 29 minutes. Phil and Rick have scored 200 and solved the problems in 30 minutes. According to the third rule, Phil ranks 3rd.

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

Time Limit: 2.0 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes
Allowed Languages: C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic*/

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class LeaderboardStandings {
	public static Map<String, Long> mapMarks = new TreeMap<String, Long>();
	public static Map<String, Long> mapTime = new TreeMap<String, Long>();
	public static Map<Integer, String> mapRanks = new TreeMap<Integer, String>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			String user = tk.nextToken();
			long time = Integer.parseInt(tk.nextToken());
			if (mapTime.containsKey(user) || mapMarks.containsKey(user)) {
				long ltime = mapTime.get(user);
				long lmarks = mapMarks.get(user);
				mapTime.put(user, time + ltime);
				mapMarks.put(user, lmarks + 100);
			} else {
				mapTime.put(user, time);
				mapMarks.put(user, 100L);
			}
		}
		Set<Entry<String, Long>> set = mapMarks.entrySet();
		List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(set);
		Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
		System.out.println(list);
		System.out.println(mapTime);
		Set<Long> marks = new TreeSet<Long>((i, j) -> i > j ? -1 : i < j ? 1 : 0);
		marks.addAll(mapMarks.values());
		Set<Long> time = new TreeSet<Long>(mapTime.values());
		System.out.println(marks + "  " + time);
		int totalStudents = mapMarks.size();
		
	}
}
