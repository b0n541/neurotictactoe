package net.b0n541.player.neuralnetwork;

import static org.junit.Assert.assertTrue;
import net.b0n541.game.GameResult;
import net.b0n541.game.TicTacToeGame;
import net.b0n541.player.random.RandomPlayer;

import org.junit.Test;

public class NeuralNetworkPlayerTest {

	TicTacToeGame game;

	@Test
	public void runWithNeuralNetworkPlayers() {
		game = new TicTacToeGame(new NeuralNetworkPlayer(), new RandomPlayer());
		game.run();
		assertTrue(game.getGameResult() != GameResult.UNDECIDED);
		assertTrue(game.getGameResult() != GameResult.O);
	}
}
