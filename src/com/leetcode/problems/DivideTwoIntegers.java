package com.leetcode.problems;

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
        long result = divideLong(Long.valueOf(dividend), Long.valueOf(divisor));
        return result > Integer.MAX_VALUE?Integer.MAX_VALUE:(int)result;
    }
    
    private long divideLong(long dividend, long divisor) {
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long ldividend = Math.abs(dividend);
        long ldivisor = Math.abs(divisor);
        if (ldivisor == 0) return Long.MAX_VALUE;
        if (ldivisor > ldividend) return 0;
        long cnt = 1;
        long sum = ldivisor;
        while (sum + sum <= ldividend) {
            sum += sum;
            cnt += cnt;
        }
        if (negative) return - (cnt + divideLong(ldividend - sum, ldivisor));
        else return (cnt + divideLong(ldividend - sum, ldivisor));
    }

}
