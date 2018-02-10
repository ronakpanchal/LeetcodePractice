package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {
	
	int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j <grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("o");
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 0;
            sb.append("D");
            dfs(grid, i + 1, j, sb);
        }
         if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 0;
            sb.append("R");
            dfs(grid, i , j + 1, sb);
         }
         if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 0;
            sb.append("L");
            dfs(grid, i, j - 1, sb);
         }
         if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 0;
            sb.append("U");
            dfs(grid, i - 1, j , sb);
         }
        sb.append("B");
    }

}
