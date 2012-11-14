package net.b0n541;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameResultTest {

	@Test
	public void horizontalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove("X", 0, 0);
		board.setMove("X", 1, 0);
		board.setMove("X", 2, 0);

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove("O", 0, 1);
		board.setMove("O", 1, 1);
		board.setMove("O", 2, 1);

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove("X", 0, 2);
		board.setMove("X", 1, 2);
		board.setMove("X", 2, 2);

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));
	}

	@Test
	public void verticalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove("X", 0, 0);
		board.setMove("X", 0, 1);
		board.setMove("X", 0, 2);

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove("O", 1, 0);
		board.setMove("O", 1, 1);
		board.setMove("O", 1, 2);

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove("X", 2, 0);
		board.setMove("X", 2, 1);
		board.setMove("X", 2, 2);

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));
	}

	@Test
	public void diagonalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove("X", 0, 0);
		board.setMove("X", 1, 1);
		board.setMove("X", 2, 2);

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove("O", 2, 0);
		board.setMove("O", 1, 1);
		board.setMove("O", 0, 2);

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));
	}
}
