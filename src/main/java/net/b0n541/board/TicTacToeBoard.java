package net.b0n541.board;

import java.util.ArrayList;
import java.util.List;

import net.b0n541.player.Move;
import net.b0n541.player.MoveSymbol;

public class TicTacToeBoard {

	private final List<List<MoveSymbol>> board;

	public TicTacToeBoard() {
		board = new ArrayList<List<MoveSymbol>>();
		board.add(new ArrayList<MoveSymbol>());
		board.add(new ArrayList<MoveSymbol>());
		board.add(new ArrayList<MoveSymbol>());
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				board.get(x).add(null);
			}
		}
	}

	public void setMove(Move move) {
		board.get(move.location.x).set(move.location.y, move.symbol);
	}

	public MoveSymbol getFieldValue(int x, int y) {
		return board.get(x).get(y);
	}

	public void clear() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				board.get(x).set(y, null);
			}
		}
	}

	public boolean isEmptyField(int x, int y) {
		return getFieldValue(x, y) == null;
	}

	public boolean hasEmptyFields() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (isEmptyField(x, y)) {
					return true;
				}
			}
		}
		return false;
	}
}
