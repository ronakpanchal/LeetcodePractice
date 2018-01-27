package com.leetcode.problems;

public class SquareRoot {
	
	 public int mySqrt(int x) {
	        if (x < 0) return -1;
	        if (x == 0 ) return 0;
	        int l = 1, h = x;
	        int m = 0;
	        while (l <= h) {
	            m = l + (h - l) / 2;
	            if (m > (x / m)) h = m - 1;
	            else if (m < (x / m)) l = m + 1;
	            else  return m;
	        }
	        return h;
	    }

}
