package net.b0n541.player;

import java.awt.Point;

import net.b0n541.board.TicTacToeBoard;

public abstract class AbstractPlayer implements TicTacToePlayer {

	protected final static String playerMove = "X";
	protected final static String opponentMove = "O";

	protected TicTacToeBoard board;

	public final void startGame() {
		board = new TicTacToeBoard();
	}

	public void setNextMove(String moveSymbol, Point move) {
		board.setMove(moveSymbol, move.x, move.y);
	}
}