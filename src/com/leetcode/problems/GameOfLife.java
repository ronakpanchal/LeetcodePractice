package com.leetcode.problems;

public class GameOfLife {
	
	public void gameOfLife(int[][] board) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, -1}, {1, 1},{-1, -1}};
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                int live = 0;
                for (int k = 0;k < dir.length;k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                        if ((board[x][y] & 1) == 1) {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 1 && live >= 2 && live <= 3) board[i][j] = 3; 
                if (board[i][j] == 0 && live == 3) board[i][j] = 2; 
            }
        }
        
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

}
