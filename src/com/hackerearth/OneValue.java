package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class OneValue {
	public static List<Integer> l = new ArrayList<Integer>();
	public static Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(tk.nextToken());
			if (type == 1) {
				int val = Integer.parseInt(tk.nextToken());
				add_to_list(val);
			} else if (type == 2) {
				int val = Integer.parseInt(tk.nextToken());
				remove_from_list(val);
			} else if (type == 3) {
				int ans = find_least_frequency();
				System.out.println(ans);
			} else if (type == 4) {
				int ans = find_highest_frequency();
				System.out.println(ans);
			}
		}
	}

	public static void add_to_list(int val) {
		// Process queries of type 1 here
		l.add(val);
	}

	public static void remove_from_list(int val) {
		// Process queries of type 2 here
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) == val) {
				l.remove(i);
				break;
			}
		}
	}

	public static int find_least_frequency() {
		// Process queries of type 3 here
		if (!l.isEmpty()) {
			processMap();
			Collection<Integer> values = m.values();
			long minFrequency = Collections.min(values);
			Integer maxKeyValue = Integer.MIN_VALUE;
			for (Map.Entry<Integer, Integer> mapEntry : m.entrySet()) {
				if (mapEntry.getValue() == minFrequency) {
					if (mapEntry.getKey() > maxKeyValue) {
						maxKeyValue = mapEntry.getKey();
						return maxKeyValue;
					}
				}

			}
		}
		return -1;
	}

	public static int find_highest_frequency() {
		// Process queries of type 4 here
		if (!l.isEmpty()) {
			processMap();
			Collection<Integer> values = m.values();
			long maxFrequency = Collections.max(values);
			Integer minKeyValue = Integer.MAX_VALUE;
			for (Map.Entry<Integer, Integer> mapEntry : m.entrySet()) {
				if (mapEntry.getValue() == maxFrequency) {
					if (mapEntry.getKey() < minKeyValue) {
						minKeyValue = mapEntry.getKey();
						return minKeyValue;
					}
				}

			}
		}
		return -1;
	}

	public static void processMap() {
		for (int i = 0; i < l.size(); i++) {
			int key = l.get(i);
			if (m.containsKey(key)) {
				int val = m.get(key);
				m.put(key, val + 1);
			} else {
				m.put(key, 1);
			}
		}
	}
}