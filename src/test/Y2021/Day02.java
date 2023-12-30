package test.Y2021;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day02 {
	private int getPosition(String filename) {
		int horizontal = 0;
		int vertical = 0;
		for (String lineAsString: FileReader.getLines(filename)) {
			String[] orders = lineAsString.split(" ");
			int moveNumber = Integer.valueOf(orders[1]);
			if (orders[0].equals("down")) {
				vertical = vertical + moveNumber;
			}
			if (orders[0].equals("forward")) {
				horizontal = horizontal + moveNumber;
			}
			if (orders[0].equals("up")) {
				vertical = vertical - moveNumber;
			}
		}
		return horizontal * vertical;
	}
	
	private int getPositionWithAim(String filename) {
		int horizontal = 0;
		int aim = 0;
		int depth = 0;
		int result = 0;
		for (String lineAsString: FileReader.getLines(filename)) {
			String[] orders = lineAsString.split(" ");
			int moveNumber = Integer.valueOf(orders[1]);
			if (orders[0].equals("down")) {
				aim = aim + moveNumber;
			}
			if (orders[0].equals("forward")) {
				depth = moveNumber * aim;
				horizontal = horizontal + moveNumber;
				result = depth + result;
			}
			if (orders[0].equals("up")) {
				aim = aim - moveNumber;
			}
		}
		return horizontal * result;
	}
	
	@Test
	void secondStar() {
		assertEquals(1451210346, this.getPositionWithAim("2021/02.txt"));
	}
	
	@Test
	void secondStarExample() {
		assertEquals(900, this.getPositionWithAim("2021/02Example.txt"));
	}
	
	@Test
	void firstStarExample() {
		assertEquals(150, this.getPosition("2021/02Example.txt"));
	}
	
	@Test
	void firstStar() {
		assertEquals(1250395, this.getPosition("2021/02.txt"));
	}

}
