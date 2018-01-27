package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void solve(char[][] board) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'B';
                        bfs(board, i, j);
                    }
                }
            }
        }
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            for (int k = 0;k < dir.length;k++) {
                int x = arr[0] + dir[k][0];
                int y = arr[1] + dir[k][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                    board[x][y] = 'B';
                    q.add(new int[]{x, y});
                }
            }
        }
    }

}
