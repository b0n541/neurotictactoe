package net.b0n541.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import net.b0n541.board.TicTacToeBoard;

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
		board.setMove("X", 0, 1);
		assertEquals("X", board.getFieldValue(0, 1));
	}

	@Test
	public void clear() {
		board.setMove("X", 0, 0);
		assertEquals("X", board.getFieldValue(0, 0));
		board.clear();
		assertNull(board.getFieldValue(0, 0));
	}

	@Test
	public void isEmptyField() {
		assertTrue(board.isEmptyField(2, 2));
		board.setMove("X", 2, 2);
		assertFalse(board.isEmptyField(2, 2));

		assertTrue(board.isEmptyField(1, 1));
		board.setMove("X", 1, 1);
		assertFalse(board.isEmptyField(1, 1));
	}
}
