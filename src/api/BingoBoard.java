package api;

public class BingoBoard {

	private int[][] numbers; 
	
	private boolean[][] isMarked;
	
	public BingoBoard(int[][] numbers) {
		this.numbers = numbers;
		this.isMarked = new boolean[numbers.length][];
		for (int y = 0; y < numbers.length; y++) {
			this.isMarked[y] = new boolean[numbers[0].length];
		}
	}
	
	public boolean isBingo() {
		return this.isBingoByColumn() || this.isBingoByRow();
	}
		
	public int getSumOfUnmarked() {
		int sum = 0;
		for (int y = 0; y < numbers.length; y++) {
			for (int x = 0; x < numbers[0].length; x++) {
				if (this.isMarked[y][x] == false) {
					sum += numbers[y][x];
				}
			}
		}
		return sum;
	}
	
	public void mark(int number) {
		for (int y = 0; y < numbers.length; y++) {
			for (int x = 0; x < numbers[0].length; x++) {
				if (numbers[y][x] == number) {
					this.isMarked[y][x] = true;
				}
			}
		}
	}
	
	private boolean isBingoByRow() {
		for (int y = 0; y < numbers.length; y++) {
			boolean isAllMarked = true;
			for (int x = 0; x < numbers[0].length; x++) {
				if (!this.isMarked[y][x]) {
					isAllMarked = false;
				}
			}
			if (isAllMarked) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isBingoByColumn() {
		for (int x = 0; x < numbers[0].length; x++) {
			boolean isAllMarked = true;
			for (int y = 0; y < numbers.length; y++) {
				if (!this.isMarked[y][x]) {
					isAllMarked = false;
				}
			}
			if (isAllMarked) {
				return true;
			}
		}
		return false;
	}
}
