package net.b0n541.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.b0n541.player.neuralnetwork.NeuralNetworkPlayer;
import net.b0n541.player.random.RandomPlayer;

import org.junit.Test;

public class TicTacToeGameTest {

	TicTacToeGame game;

	@Test
	public void runWithRandomPlayers() {
		game = new TicTacToeGame(new RandomPlayer(), new RandomPlayer());
		game.run();
		System.out.println(game.printBoard());
		System.out.println(game.getGameResult());
		assertTrue(game.printBoard().contains("X"));
		assertTrue(game.printBoard().contains("O"));

		assertTrue(game.getGameResult() != GameResult.UNDECIDED);
		if (game.getGameResult() == GameResult.DRAW) {
			assertFalse(game.printBoard().contains(" "));
		}
	}

	@Test
	public void runWithNeuralNetworkPlayers() {
		game = new TicTacToeGame(new NeuralNetworkPlayer(),
				new NeuralNetworkPlayer());
		game.run();
		assertTrue(game.getGameResult() != GameResult.UNDECIDED);
	}
}
