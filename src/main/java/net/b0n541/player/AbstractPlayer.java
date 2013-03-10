package net.b0n541.player;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import net.b0n541.board.TicTacToeBoard;

public abstract class AbstractPlayer implements TicTacToePlayer {

	protected TicTacToeBoard board = new TicTacToeBoard();
	protected MoveSymbol symbol;

	@Override
	public final void startGame(MoveSymbol symbol) {
		board.clear();
		this.symbol = symbol;

		prepareForGame();
	}

	protected abstract void prepareForGame();

	@Override
	public void setNextMove(Move move) {
		board.setMove(move);
	}

	protected List<Move> getPossibleMoves() {
		List<Move> result = new ArrayList<>();
		for (Point emptyLocation : getEmptyLocations()) {
			result.add(new Move(symbol, emptyLocation));
		}
		return result;
	}

	protected List<Point> getEmptyLocations() {
		List<Point> result = new ArrayList<>();

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
