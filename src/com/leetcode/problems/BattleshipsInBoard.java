package com.leetcode.problems;

public class BattleshipsInBoard {

	public int countBattleships(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					countBattleships(board, i, j, 'V');
					board[i][j] = 'X';
					countBattleships(board, i, j, 'H');
					cnt++;
				}
			}
		}
		return cnt;
	}

	void countBattleships(char[][] board, int i, int j, char dir) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') return;
		if (dir == 'V') {
			board[i][j] = '.';
			countBattleships(board, i + 1, j, 'V');
			countBattleships(board, i - 1, j, 'V');
		} else {
			board[i][j] = '.';
			countBattleships(board, i, j + 1, 'H');
			countBattleships(board, i, j - 1, 'H');
		}
	}

}
