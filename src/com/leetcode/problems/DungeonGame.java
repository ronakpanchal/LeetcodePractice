package com.leetcode.problems;

public class DungeonGame {
	
	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        dungeon[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2;i >= 0;i--) dungeon[i][n - 1] = Math.max(1, dungeon[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int i = n - 2;i >= 0;i--) dungeon[m - 1][i] = Math.max(1, dungeon[m - 1][i + 1] - dungeon[m  - 1][i]);
        for (int i = m - 2;i >= 0;i--) {
            for (int j = n - 2;j >= 0;j--) {
                dungeon[i][j] = Math.min(Math.max(dungeon[i + 1][j] - dungeon[i][j], 1), Math.max(dungeon[i][j + 1] - dungeon[i][j], 1));
            }
        }
        return dungeon[0][0];
    }

}
