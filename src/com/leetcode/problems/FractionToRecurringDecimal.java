package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	
	  public String fractionToDecimal(int numerator, int denominator) {
	        StringBuilder sb = new StringBuilder();
	        if (numerator == 0) return "0";
	        if ((numerator < 0 ) ^ (denominator < 0)) sb.append("-");
	        long dividend = Math.abs(Long.valueOf(numerator));
	        long divisor =  Math.abs(Long.valueOf(denominator));
	        sb.append(dividend / divisor);
	        long rem = dividend % divisor;
	        if (rem == 0) return sb.toString();
	        sb.append(".");
	        Map<Long, Integer> map = new HashMap<Long, Integer>();
	        while (rem > 0) {
	             if (map.containsKey(rem)) {
	                sb.insert(map.get(rem), "(");
	                sb.append(")");
	                break;
	            }
	            map.put(rem, sb.length());
	            rem = rem * 10;
	            sb.append(String.valueOf(rem / divisor));
	            rem = rem % divisor;
	        }
	        return sb.toString();
	    }

}
