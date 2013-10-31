package net.b0n541.player.neuralnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.b0n541.game.GameResult;
import net.b0n541.player.AbstractPlayer;
import net.b0n541.player.Move;
import net.b0n541.player.MoveSymbol;

public class NeuralNetworkPlayer extends AbstractPlayer {

	private static final int INPUT_COUNT = 18;
	private static final double INACTIVE = 0.0;
	private static final double ACTIVE = 1.0;

	int[] hiddenLayers = { 10 };
	NetworkTopology topo = new NetworkTopology(INPUT_COUNT, 3,
			hiddenLayers.length, hiddenLayers);
	NeuralNetwork network = new EncogNetworkWrapper(topo, true);

	List<double[]> gameInputs = new ArrayList<>();

	@Override
	protected void prepareForGame() {
		gameInputs.clear();
	}

	@Override
	public Move getNextMove() {

		double[] oldMoves = getNetworkInputsForOldMoves();
		List<Move> possibleMoves = getPossibleMoves();
		Map<Move, double[]> moveInputs = new HashMap<>();
		Map<Move, double[]> moveOutputs = new HashMap<>();

		for (Move move : possibleMoves) {

			double[] inputs = oldMoves.clone();
			// set next move
			inputs[move.location.y * 3 + move.location.x] = ACTIVE;
			moveInputs.put(move, inputs);
			// ask network
			double[] outcome = network.getPredictedOutcome(inputs);
			moveOutputs.put(move, outcome);
		}

		Move bestWonMove = null;
		double bestWonOutcome = Double.MIN_VALUE;
		Move bestLostMove = null;
		double bestLostOutcome = Double.MIN_VALUE;
		Move bestDrawMove = null;
		double bestDrawOutcome = Double.MIN_VALUE;
		for (Entry<Move, double[]> entry : moveOutputs.entrySet()) {
			if (entry.getValue()[0] > bestWonOutcome) {
				bestWonMove = entry.getKey();
				bestWonOutcome = entry.getValue()[0];
			}
			if (entry.getValue()[1] > bestLostOutcome) {
				bestLostMove = entry.getKey();
				bestLostOutcome = entry.getValue()[1];
			}
			if (entry.getValue()[2] > bestDrawOutcome) {
				bestDrawMove = entry.getKey();
				bestDrawOutcome = entry.getValue()[2];
			}
		}

		Move result = null;
		if (bestLostOutcome > bestWonOutcome
				&& bestDrawOutcome > bestWonOutcome) {
			result = bestDrawMove;
		} else {
			result = bestWonMove;
		}
		// if (bestWonMove != null) {
		// result = bestWonMove;
		// } else if (bestDrawMove != null && bestDrawOutcome > bestWonOutcome)
		// {
		// result = bestDrawMove;
		// }

		if (result == null) {
			// play random move
			Random random = new Random();
			result = possibleMoves.get(random.nextInt(possibleMoves.size()));
			System.out.println("Playing random move.");
		}

		gameInputs.add(moveInputs.get(result));

		return result;
	}

	private double[] getNetworkInputsForOldMoves() {
		double[] inputs = new double[INPUT_COUNT];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (board.getFieldValue(x, y) == null) {
					// do nothing
				} else if (symbol == board.getFieldValue(x, y)) {
					// players moves
					inputs[y * 3 + x] = ACTIVE;
				} else if (symbol != board.getFieldValue(x, y)) {
					// opponents moves
					inputs[INPUT_COUNT / 2 + y * 3 + x] = ACTIVE;
				}
			}
		}

		return inputs;
	}

	@Override
	public void finishGame(GameResult result) {
		double[] expectedOutput = getOutputsForGameResult(result);
		Double errorSum = 0.0;
		for (double[] input : gameInputs) {
			errorSum += network.adjustWeights(input, expectedOutput);
		}
		// System.out.println("Avg error: " + errorSum / gameInputs.size());
		// System.out.println("Avg diff: " + network.getAvgDiff());
	}

	private double[] getOutputsForGameResult(GameResult result) {
		if (result == GameResult.X && symbol == MoveSymbol.X
				|| result == GameResult.O && symbol == MoveSymbol.O) {
			// game won
			return new double[] { 1.0, 0.0, 0.0 };
		} else if (result == GameResult.X && symbol == MoveSymbol.O
				|| result == GameResult.O && symbol == MoveSymbol.X) {
			// game lost
			return new double[] { 0.0, 1.0, 0.0 };
		} else if (result == GameResult.DRAW) {
			// draw
			return new double[] { 0.0, 0.0, 1.0 };
		}

		throw new IllegalArgumentException("Invalid game result: " + result);
	}
}
