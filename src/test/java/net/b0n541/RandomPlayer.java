package net.b0n541;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer extends AbstractPlayer implements TicTacToePlayer {

	private final static Random rand = new Random();

	public Point getNextMove() {
		List<Point> possibleMoves = getPossibleMoves();
		return possibleMoves.get(rand.nextInt(possibleMoves.size()));
	}

	private List<Point> getPossibleMoves() {
		List<Point> result = new ArrayList<Point>();
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (board.isEmptyField(x, y)) {
					result.add(new Point(x, y));
				}
			}
		}
		return result;
	}
}
