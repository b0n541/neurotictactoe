package net.b0n541.player.neuralnetwork;

import java.util.ArrayList;
import java.util.List;

import net.b0n541.player.AbstractPlayer;
import net.b0n541.player.Move;

public class NeuralNetworkPlayer extends AbstractPlayer {

	private static final int INPUT_COUNT = 18;
	private static final double INACTIVE = 0.0;
	private static final double ACTIVE = 1.0;

	int[] hiddenLayers = { 10 };
	NetworkTopology topo = new NetworkTopology(INPUT_COUNT, 1,
			hiddenLayers.length, hiddenLayers);
	NeuralNetwork network = new EncogNetworkWrapper(topo, false);

	List<Move> gameMoves = new ArrayList<>();

	@Override
	protected void prepareForGame() {
		gameMoves.clear();
	}

	@Override
	public Move getNextMove() {

		Move result = getBestMove();
		gameMoves.add(result);

		return result;
	}

	private Move getBestMove() {

		Move result = null;
		double bestOutcome = -1000.0;
		double[] oldMoves = getNetworkInputsForOldMoves();
		for (Move move : getPossibleMoves()) {

			double[] inputs = oldMoves.clone();
			// set next move
			inputs[move.location.y * move.location.x + move.location.x] = ACTIVE;

			double outcome = network.getPredictedOutcome(inputs);
			if (outcome > bestOutcome) {
				bestOutcome = outcome;
				result = move;
			}
		}
		return result;
	}

	private double[] getNetworkInputsForOldMoves() {
		double[] inputs = new double[INPUT_COUNT];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (symbol == board.getFieldValue(x, y)) {
					// players moves
					inputs[y * x + x] = ACTIVE;
					inputs[INPUT_COUNT / 2 + y * x + x] = INACTIVE;
				} else if (symbol == board.getFieldValue(x, y)) {
					// opponents moves
					inputs[y * x + x] = INACTIVE;
					inputs[INPUT_COUNT / 2 + y * x + x] = ACTIVE;
				} else {
					// empty field
					inputs[y * x + x] = INACTIVE;
					inputs[INPUT_COUNT / 2 + y * x + x] = INACTIVE;
				}
			}
		}

		return inputs;
	}
}
