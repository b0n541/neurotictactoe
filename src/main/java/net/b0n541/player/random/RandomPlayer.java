package net.b0n541.player.random;

import java.util.List;
import java.util.Random;

import net.b0n541.player.AbstractPlayer;
import net.b0n541.player.Move;
import net.b0n541.player.TicTacToePlayer;

public class RandomPlayer extends AbstractPlayer implements TicTacToePlayer {

	private final static Random rand = new Random();

	@Override
	public Move getNextMove() {
		List<Move> possibleMoves = getPossibleMoves();
		return possibleMoves.get(rand.nextInt(possibleMoves.size()));
	}

	@Override
	protected void prepareForGame() {
		// nothing to do
	}
}
