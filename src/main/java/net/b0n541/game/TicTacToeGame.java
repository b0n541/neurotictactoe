package net.b0n541.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.b0n541.board.TicTacToeBoard;
import net.b0n541.player.Move;
import net.b0n541.player.MoveSymbol;
import net.b0n541.player.TicTacToePlayer;

public class TicTacToeGame {

	private TicTacToeBoard board = new TicTacToeBoard();

	private List<TicTacToePlayer> player = new ArrayList<>();
	private Map<TicTacToePlayer, MoveSymbol> moveSymbols = new HashMap<>();

	public TicTacToeGame(TicTacToePlayer player1, TicTacToePlayer player2) {
		player.add(player1);
		player.add(player2);
		moveSymbols.put(player1, MoveSymbol.X);
		moveSymbols.put(player2, MoveSymbol.O);
	}

	public void run() {

		player.get(0).startGame(MoveSymbol.X);
		player.get(1).startGame(MoveSymbol.O);

		int moveNo = -1;
		do {
			moveNo++;
			Move nextMove = getNextPlayer(moveNo).getNextMove();
			board.setMove(nextMove);
			for (TicTacToePlayer currPlayer : player) {
				currPlayer.setNextMove(nextMove);
			}
		} while (getGameResult() == GameResult.UNDECIDED);

		for (TicTacToePlayer currPlayer : player) {
			currPlayer.finishGame(getGameResult());
		}
	}

	private TicTacToePlayer getNextPlayer(int moveNo) {
		return player.get(moveNo % 2);
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
