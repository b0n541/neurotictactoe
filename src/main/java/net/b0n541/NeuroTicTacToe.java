package net.b0n541;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import net.b0n541.game.GameResult;
import net.b0n541.game.TicTacToeGame;
import net.b0n541.player.TicTacToePlayer;
import net.b0n541.player.neuralnetwork.NeuralNetworkPlayer;
import net.b0n541.player.random.RandomPlayer;

public class NeuroTicTacToe {

	static DecimalFormat format = new DecimalFormat("0.0000");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TicTacToePlayer nnPlayer = new NeuralNetworkPlayer();
		TicTacToePlayer nnPlayer2 = new NeuralNetworkPlayer();
		TicTacToePlayer rndPlayer = new RandomPlayer();
		TicTacToePlayer rndPlayer2 = new RandomPlayer();

		Map<GameResult, Long> results = new HashMap<>();
		results.put(GameResult.X, 0L);
		results.put(GameResult.O, 0L);
		results.put(GameResult.DRAW, 0L);
		long gameNo = 0;
		while (gameNo < 10000000) {
			gameNo++;
			// results: X: 0.58 O: 0.28 Draw: 0.12
			// TicTacToeGame game = new TicTacToeGame(rndPlayer, rndPlayer2);
			TicTacToeGame game = new TicTacToeGame(nnPlayer, rndPlayer);
			// TicTacToeGame game = new TicTacToeGame(rndPlayer, nnPlayer);
			// TicTacToeGame game = new TicTacToeGame(nnPlayer, nnPlayer2);

			game.run();

			GameResult gameResult = game.getGameResult();
			results.put(gameResult, results.get(gameResult) + 1);

			Long allGames = results.get(GameResult.X)
					+ results.get(GameResult.O) + results.get(GameResult.DRAW);

			if (gameNo % 1000 == 0) {
				System.out.println("Game no. "
						+ gameNo
						+ " X: "
						+ results.get(GameResult.X)
						+ " ("
						+ format.format(results.get(GameResult.X).doubleValue()
								/ allGames)
						+ ") O: "
						+ results.get(GameResult.O)
						+ " ("
						+ format.format(results.get(GameResult.O).doubleValue()
								/ allGames)
						+ ") DRAW: "
						+ results.get(GameResult.DRAW)
						+ " ("
						+ format.format(results.get(GameResult.DRAW)
								.doubleValue() / allGames) + ")");
			}
		}
	}
}
