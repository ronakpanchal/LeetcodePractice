package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	
	 public int numIslands(char[][] grid) {
        int cnt = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] arr = q.poll();
                        for (int k = 0;k < dir.length;k++) {
                            int x = arr[0] + dir[k][0];
                            int y = arr[1] + dir[k][1];
                            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') continue;
                            grid[x][y] = '0';
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return cnt;
	    }

}
