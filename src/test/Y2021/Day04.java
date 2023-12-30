package test.Y2021;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import api.BingoBoard;

class Day04 {
	
	public List<Integer> getDrawnNumbers(List<String> lines) {
		List<Integer> drawnNumbers = new ArrayList<Integer>();
		for (String drawnNumber : lines.get(0).split(",")) {
			drawnNumbers.add(Integer.valueOf(drawnNumber));
		}
		return drawnNumbers;
	}
	
	public List<BingoBoard> getBoards(List<String> lines) {
		List<BingoBoard> boards = new ArrayList<BingoBoard>();
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		int lineIndex = 2;
		lines.add("");
		while (lineIndex < lines.size()) {
			String line = lines.get(lineIndex);
			if (line.equals("")) {
				boards.add(new BingoBoard(this.matrixListToArray(matrix)));
				matrix = new ArrayList<List<Integer>>();
			} else {
				List<Integer> row = new ArrayList<Integer>();
				for (String rowDigit : line.split(" ")) {
					if (!rowDigit.equals("")) {
						row.add(Integer.valueOf(rowDigit));
					}
				}
				matrix.add(row);
			}
			lineIndex++;
		}
		return boards;
	}
	
	public int[][] matrixListToArray(List<List<Integer>> matrix) {
		int[][] matrixArray = new int[matrix.size()][];
		for (int y = 0 ; y < matrix.size() ; y++) {
			List<Integer> line = matrix.get(y);
			int[] lineArray = new int[line.size()];
			for (int x = 0 ; x < line.size() ; x++) {
				lineArray[x] = line.get(x);
			}
			matrixArray[y] = lineArray;
		}
		return matrixArray;
	}

	public int getResultOfWinnerBoard(String filename) {
		List<String> lines = api.FileReader.getLines(filename);
		List<BingoBoard> boards = this.getBoards(lines);
		List<Integer> drawnNumbers = this.getDrawnNumbers(lines);
		for (int drawnNumber : drawnNumbers) {
			for (BingoBoard board : boards) {
				board.mark(drawnNumber);
				if (board.isBingo()) {
					return board.getSumOfUnmarked() * drawnNumber;
				}
			}
		}
		return 0;
	}
	
	public int getResultOfLoserBoard(String filename) {
		List<String> lines = api.FileReader.getLines(filename);
		List<BingoBoard> boards = this.getBoards(lines);
		List<Integer> drawnNumbers = this.getDrawnNumbers(lines);
		for (int drawnNumber : drawnNumbers) {
			for (int boardIndex = boards.size() - 1 ; boardIndex > -1; boardIndex--) {
				BingoBoard board = boards.get(boardIndex);
				if (!board.isBingo()) {
					board.mark(drawnNumber);
					if (board.isBingo()) {
						boards.remove(boardIndex);
						if (boards.size() == 0) {
							return drawnNumber * board.getSumOfUnmarked();
						}
					}
				}
			}
		}
		return 0;
	}
	
	@Test
	void firstStarExample() {
		assertEquals(4512, this.getResultOfWinnerBoard("2021/04Example.txt"));
	}
	
	@Test
	void firstStar() {
		assertEquals(8136, this.getResultOfWinnerBoard("2021/04.txt"));
	}

	@Test
	void secondStarExample() {
		assertEquals(1924, this.getResultOfLoserBoard("2021/04Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(12738, this.getResultOfLoserBoard("2021/04.txt"));
	}
	
}
