package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			int len = str.length();
			sb.append(len).append("/").append(str);
		}
		return sb.toString();
	}

	public List<String> decode(String s) {
		int i = 0;
		List<String> result = new ArrayList<String>();
		while (i < s.length()) {
			int index = s.indexOf("/", i);
			int len = Integer.parseInt(s.substring(i, index));
			String str = s.substring(index + 1, index + len + 1);
			result.add(str);
			i = index + len + 1;
		}
		return result;
	}

}
