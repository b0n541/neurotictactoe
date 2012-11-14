package net.b0n541.board;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

	private final List<List<String>> board;

	public TicTacToeBoard() {
		board = new ArrayList<List<String>>();
		board.add(new ArrayList<String>());
		board.add(new ArrayList<String>());
		board.add(new ArrayList<String>());
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				board.get(x).add(null);
			}
		}
	}

	public void setMove(String playerMove, int x, int y) {
		board.get(x).set(y, playerMove);
	}

	public String getFieldValue(int x, int y) {
		return board.get(x).get(y);
	}

	public void clear() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				setMove(null, x, y);
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
