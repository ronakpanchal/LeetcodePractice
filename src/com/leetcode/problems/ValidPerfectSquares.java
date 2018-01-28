package com.leetcode.problems;

public class ValidPerfectSquares {
	
	public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        int l = 1, h = num;
        long m = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (m * m > num) h = (int)(m - 1);
            else if (m * m < num) l = (int)(m + 1);
            else  return true;
        }
        return false;
    }

}
