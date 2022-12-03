package com.robot.simulation;

public class SquareTable {
	private int rows;
	private int columns;

	public SquareTable(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public boolean validatePosition(Position position) {
		int xValue = position.getX();
		int yValue = position.getY();
		if (xValue > rows || xValue < 0 ||
				yValue > columns || yValue < 0) {
			return false;
		}
		return true;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
