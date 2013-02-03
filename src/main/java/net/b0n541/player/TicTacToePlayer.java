package net.b0n541.player;

public interface TicTacToePlayer {

	public void startGame(MoveSymbol symbol);

	public Move getNextMove();

	public void setNextMove(Move move);
}
