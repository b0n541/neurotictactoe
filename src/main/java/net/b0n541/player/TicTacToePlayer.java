package net.b0n541.player;

import java.awt.Point;

public interface TicTacToePlayer {

	public void startGame();

	public Point getNextMove();

	public void setNextMove(String moveSymbol, Point move);
}
