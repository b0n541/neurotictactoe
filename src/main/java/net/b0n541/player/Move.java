package net.b0n541.player;

import java.awt.Point;

public class Move {

	public Point location;
	public MoveSymbol symbol;

	public Move(MoveSymbol symbol, Point location) {
		this.symbol = symbol;
		this.location = location;
	}

	public Move(MoveSymbol symbol, int x, int y) {
		this(symbol, new Point(x, y));
	}

	@Override
	public String toString() {
		return location.toString() + " " + symbol;
	}
}
