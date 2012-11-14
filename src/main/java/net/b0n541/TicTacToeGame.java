package net.b0n541;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeGame {

	private TicTacToeBoard board = new TicTacToeBoard();
	private boolean finished = false;

	private List<TicTacToePlayer> player = new ArrayList<TicTacToePlayer>();
	private Map<TicTacToePlayer, String> moveSymbols = new HashMap<TicTacToePlayer, String>();

	public TicTacToeGame(TicTacToePlayer player1, TicTacToePlayer player2) {
		player.add(player1);
		player.add(player2);
		moveSymbols.put(player1, "X");
		moveSymbols.put(player2, "O");
	}

	public void run() {

		for (TicTacToePlayer currPlayer : player) {
			currPlayer.startGame();
		}

		int move = -1;
		while (!finished) {

			move++;
			Point nextMove = getNextPlayer(move).getNextMove();
			board.setMove(moveSymbols.get(getNextPlayer(move)), nextMove.x,
					nextMove.y);
			for (TicTacToePlayer currPlayer : player) {
				currPlayer.setNextMove(moveSymbols.get(getNextPlayer(move)),
						nextMove);
			}

			if (getGameResult() == GameResult.X_WON
					|| getGameResult() == GameResult.O_WON || move == 8) {
				finished = true;
			}
		}
	}

	public boolean isFinished() {
		return finished;
	}

	private TicTacToePlayer getNextPlayer(int move) {
		return player.get(move % 2);
	}

	public GameResult getGameResult() {
		return GameResult.valueOf(board);
	}

	public String printBoard() {
		String result = new String();
		result += "+-+-+-+\n";
		for (int y = 0; y < 3; y++) {
			result += "|";
			for (int x = 0; x < 3; x++) {
				result += board.getFieldValue(x, y) == null ? " |" : board
						.getFieldValue(x, y) + "|";
			}
			result += "\n";
			result += "+-+-+-+\n";
		}
		return result;
	}
}
