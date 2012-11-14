package net.b0n541.game;

import net.b0n541.board.TicTacToeBoard;

public enum GameResult {
	UNDECIDED, X_WON, O_WON, DRAW;

	public static GameResult valueOf(TicTacToeBoard board) {
		GameResult result = UNDECIDED;

		result = getHorizontalWin(board);

		if (result == UNDECIDED) {
			result = getVerticalWin(board);
		}

		if (result == UNDECIDED) {
			result = getDiagonalWin(board);
		}

		if (result == UNDECIDED && !board.hasEmptyFields()) {
			result = DRAW;
		}

		return result;
	}

	private static GameResult getHorizontalWin(TicTacToeBoard board) {
		GameResult result = UNDECIDED;
		for (int y = 0; y < 3 && result == UNDECIDED; y++) {

			String firstMove = board.getFieldValue(0, y);
			boolean allMovesTheSame = true;
			if (firstMove != null) {
				for (int x = 1; x < 3; x++) {
					if (!firstMove.equals(board.getFieldValue(x, y))) {
						allMovesTheSame = false;
					}
				}
				if (allMovesTheSame) {
					result = getWinner(firstMove);
				}
			}
		}
		return result;
	}

	private static GameResult getVerticalWin(TicTacToeBoard board) {
		GameResult result = UNDECIDED;
		for (int x = 0; x < 3 && result == UNDECIDED; x++) {

			String firstMove = board.getFieldValue(x, 0);
			boolean allMovesTheSame = true;
			if (firstMove != null) {
				for (int y = 1; y < 3; y++) {
					if (!firstMove.equals(board.getFieldValue(x, y))) {
						allMovesTheSame = false;
					}
				}
				if (allMovesTheSame) {
					result = getWinner(firstMove);
				}
			}
		}
		return result;
	}

	private static GameResult getDiagonalWin(TicTacToeBoard board) {
		GameResult result = UNDECIDED;

		if (board.getFieldValue(0, 0) == board.getFieldValue(1, 1)
				&& board.getFieldValue(1, 1) == board.getFieldValue(2, 2)) {
			result = getWinner(board.getFieldValue(1, 1));
		} else if (board.getFieldValue(2, 0) == board.getFieldValue(1, 1)
				&& board.getFieldValue(1, 1) == board.getFieldValue(0, 2)) {
			result = getWinner(board.getFieldValue(1, 1));
		}

		return result;
	}

	private static GameResult getWinner(String move) {
		if ("X".equals(move)) {
			return X_WON;
		} else if ("O".equals(move)) {
			return O_WON;
		}
		return UNDECIDED;
	}
}
