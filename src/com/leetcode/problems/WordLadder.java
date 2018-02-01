package com.leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        Set<String> beginWords = new HashSet<String>();
	        Set<String> endWords = new HashSet<String>();
	        Set<String> dictionary = new HashSet<String>(wordList);
	        beginWords.add(beginWord);
	        if (dictionary.contains(endWord)) endWords.add(endWord);
	        dictionary.remove(beginWord);
	        dictionary.remove(endWord);
	        int level = 2;
	        while (!beginWords.isEmpty()) {
	            if (beginWords.size() > endWords.size()) {
	                Set<String> temp = beginWords;
	                beginWords = endWords;
	                endWords = temp;
	            }
	            Set<String> next = new HashSet<String>(); 
	            for (String s:beginWords) {
	                char[] str = s.toCharArray();
	                for (int i = 0;i < str.length;i++) {
	                    char ch = str[i];
	                    for (char c = 'a';c <= 'z';c++) {
	                        str[i] = c;
	                        String ss = String.valueOf(str);
	                        if (endWords.contains(ss)) {
	                            return level;
	                        } 
	                        if (dictionary.contains(ss)) {
	                            next.add(ss);
	                            dictionary.remove(ss);                    
	                        }
	                    }
	                    str[i] = ch;
	                }
	            }
	            beginWords = next;
	            level++;
	        }
	        return 0;
	    }

}
