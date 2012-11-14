package net.b0n541.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import net.b0n541.game.GameResult;
import net.b0n541.game.TicTacToeGame;
import net.b0n541.player.RandomPlayer;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {

	TicTacToeGame game;

	@Before
	public void initGame() {
		game = new TicTacToeGame(new RandomPlayer(), new RandomPlayer());
	}

	@Test
	public void run() {
		game.run();
		System.out.println(game.printBoard());
		System.out.println(game.getGameResult());
		assertTrue(game.printBoard().contains("X"));
		assertTrue(game.printBoard().contains("O"));

		if (game.getGameResult() == GameResult.DRAW) {
			assertFalse(game.printBoard().contains(" "));
		}
	}
}
