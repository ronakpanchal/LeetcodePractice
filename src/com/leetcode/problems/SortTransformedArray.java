package com.leetcode.problems;

public class SortTransformedArray {
	
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        if (a > 0) {
            int  k = n - 1;
            while (i <= j) {
                int n1 = evaluate(nums[i], a, b, c);
                int n2 = evaluate(nums[j], a, b, c);
                if (n1 <= n2) {
                    result[k--] = n2;
                    j--;
                } else {
                    result[k--] = n1;
                    i++;
                }
            } 
        } else {
            int k = 0;
            while (i <= j) {
                int n1 = evaluate(nums[i], a, b, c);
                int n2 = evaluate(nums[j], a, b, c);
                if (n1 <= n2) {
                    result[k++] = n1;
                    i++;
                } else {
                    result[k++] = n2;
                    j--;
                }
            }
        }
        return result;
    }
    
    int evaluate(int x, int a, int b, int c) {
        return (a * x * x) + (b * x) + c;
    }

}
