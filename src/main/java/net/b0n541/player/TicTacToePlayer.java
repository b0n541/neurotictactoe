package net.b0n541.player;

import net.b0n541.game.GameResult;

public interface TicTacToePlayer {

	public void startGame(MoveSymbol symbol);

	public Move getNextMove();

	public void setNextMove(Move move);

	public void finishGame(GameResult result);
}
