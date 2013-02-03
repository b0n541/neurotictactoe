package net.b0n541.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.b0n541.player.Move;
import net.b0n541.player.MoveSymbol;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeBoardTest {

	TicTacToeBoard board;

	@Before
	public void initBoard() {
		board = new TicTacToeBoard();
	}

	@Test
	public void setMove() {
		assertNull(board.getFieldValue(0, 1));
		board.setMove(new Move(MoveSymbol.X, 0, 1));
		assertEquals(MoveSymbol.X, board.getFieldValue(0, 1));
	}

	@Test
	public void clear() {
		board.setMove(new Move(MoveSymbol.X, 0, 0));
		assertEquals(MoveSymbol.X, board.getFieldValue(0, 0));
		board.clear();
		assertNull(board.getFieldValue(0, 0));
	}

	@Test
	public void isEmptyField() {
		assertTrue(board.isEmptyField(2, 2));
		board.setMove(new Move(MoveSymbol.X, 2, 2));
		assertFalse(board.isEmptyField(2, 2));
	}
}
