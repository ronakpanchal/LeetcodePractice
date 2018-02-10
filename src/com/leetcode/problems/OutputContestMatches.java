package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches {

	public static void main(String[] args) {
		OutputContestMatches obj = new OutputContestMatches();
		obj.findContestMatch(8);

	}

	public String findContestMatch(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) list.add(String.valueOf(i));
		while (list.size() >= 2) {
			List<String> newList = new ArrayList<String>();
			findContestMatch(list, 0, list.size() - 1, newList);
			list = newList;
		}
		return list.get(0);
	}

	void findContestMatch(List<String> list, int i, int j, List<String> list1) {
		if (i >= j) return;
		list1.add("(" + list.get(i) + "," + list.get(j) + ")");
		findContestMatch(list, i + 1, j - 1, list1);
	}

}
