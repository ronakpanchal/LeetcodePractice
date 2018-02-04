package com.leetcode.problems;

public class LonelyPixelI {
	
	public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int cnt = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;cols[j]++;
                }
            }
        }
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (picture[i][j] == 'B') {
                    if (rows[i] == 1 && cols[j] == 1) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
        
    }

}
