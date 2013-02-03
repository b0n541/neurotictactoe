package net.b0n541.game;

import static org.junit.Assert.assertEquals;
import net.b0n541.board.TicTacToeBoard;
import net.b0n541.player.Move;
import net.b0n541.player.MoveSymbol;

import org.junit.Test;

public class GameResultTest {

	@Test
	public void horizontalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.X, 0, 0));
		board.setMove(new Move(MoveSymbol.X, 1, 0));
		board.setMove(new Move(MoveSymbol.X, 2, 0));

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.O, 0, 1));
		board.setMove(new Move(MoveSymbol.O, 1, 1));
		board.setMove(new Move(MoveSymbol.O, 2, 1));

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.X, 0, 2));
		board.setMove(new Move(MoveSymbol.X, 1, 2));
		board.setMove(new Move(MoveSymbol.X, 2, 2));

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));
	}

	@Test
	public void verticalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.X, 0, 0));
		board.setMove(new Move(MoveSymbol.X, 0, 1));
		board.setMove(new Move(MoveSymbol.X, 0, 2));

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.O, 1, 0));
		board.setMove(new Move(MoveSymbol.O, 1, 1));
		board.setMove(new Move(MoveSymbol.O, 1, 2));

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.X, 2, 0));
		board.setMove(new Move(MoveSymbol.X, 2, 1));
		board.setMove(new Move(MoveSymbol.X, 2, 2));

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));
	}

	@Test
	public void diagonalWin() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.X, 0, 0));
		board.setMove(new Move(MoveSymbol.X, 1, 1));
		board.setMove(new Move(MoveSymbol.X, 2, 2));

		assertEquals(GameResult.X_WON, GameResult.valueOf(board));

		board = new TicTacToeBoard();
		board.setMove(new Move(MoveSymbol.O, 2, 0));
		board.setMove(new Move(MoveSymbol.O, 1, 1));
		board.setMove(new Move(MoveSymbol.O, 0, 2));

		assertEquals(GameResult.O_WON, GameResult.valueOf(board));
	}
}
