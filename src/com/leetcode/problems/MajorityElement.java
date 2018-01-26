package com.leetcode.problems;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        int n = nums.length;
        for (int i = 1;i < nums.length;i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } 
            else if (nums[i] == candidate) count++;
            else if (nums[i] != candidate) count--;
        }
        count = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == candidate) count++;
        }
        return count >= (n / 2)?candidate:-1;
    }

}
