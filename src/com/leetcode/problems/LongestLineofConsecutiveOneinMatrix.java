package com.leetcode.problems;

public class LongestLineofConsecutiveOneinMatrix {
	
	public int longestLine(int[][] M) {
        int m = M.length;
        if (m == 0) return 0;
        int n = M[0].length;
        int max = 0;
        int[][][] dp = new int[m][n][4];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
                    if (j >= 1) dp[i][j][0] += dp[i][j - 1][0];
                    if (i >= 1) dp[i][j][1] += dp[i - 1][j][1];
                    if (i >= 1 && j >= 1) dp[i][j][2] += dp[i - 1][j - 1][2];
                    if (i >= 1 && j + 1 < n ) dp[i][j][3] += dp[i - 1][j + 1][3];
                    max = Math.max(Math.max(dp[i][j][0], dp[i][j][1]), max);
                    max = Math.max(Math.max(dp[i][j][2], dp[i][j][3]), max);
                }
            }
        }
        return max;
    }

}
