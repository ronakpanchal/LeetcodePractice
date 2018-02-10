package com.leetcode.problems;

import java.util.List;

public class LongestWordinDictionaryThroughDeleting {
	
	public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str:d) {
             if (isSubSequence(str, s)) {
                 if (str.length() > result.length()) {
                     result = str;
                 } else if (result.length() == str.length()) {
                     if (str.compareTo(result) < 0) {
                         result = str;
                     } 
                 }
             }
        }
        return result;
    }
    
    private boolean isSubSequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i))j++;
        }
        return j == x.length();
    } 

}
