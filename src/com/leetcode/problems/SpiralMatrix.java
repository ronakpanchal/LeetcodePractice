package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
	
	
	public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<Integer>();
        int lr = 0, lc = 0,  hr = matrix.length - 1, hc = matrix[0].length - 1, direction = 0;
        while (lr <= hr && lc <= hc) {
            if (direction == 0) {
                for (int i = lc;i <= hc;i++) result.add(matrix[lr][i]);
                lr++;
            } else if (direction == 1) {
                for (int i = lr;i <= hr;i++) result.add(matrix[i][hc]);
                hc--;
            } else if (direction == 2) {
                for (int i = hc;i >= lc;i--) result.add(matrix[hr][i]);
                hr--;
            } else {
                for (int i = hr;i >= lr;i--) result.add(matrix[i][lc]);
                lc++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }

}
