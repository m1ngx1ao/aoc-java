package test.Y2015;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day01 {
	
	private int getFloor(String filename) {
		int floor = 0;
		for (String lineAsString: FileReader.getLines(filename).get(0).split("")) {
				if (lineAsString.equals("(")) {
					floor = floor + 1;
				}
				if (lineAsString.equals(")")) {
					floor = floor - 1;
				}
			}
		return floor;
	}
	
	private int getMinusOne(String filename) {
		int floor = 0;
		int counter = 0;
		for (String lineAsString: FileReader.getLines(filename).get(0).split("")) {
			counter++;
			if (lineAsString.equals("(")) {
				floor = floor + 1;
			}
			if (lineAsString.equals(")")) {
				floor = floor - 1;
				if (floor == -1) {
					return counter;
				}
			}
		}
		return counter;
	}
	
	@Test
	void firstStar() {
		assertEquals(280, this.getFloor("2015/01.txt"));
	}
	
	@Test
	void firstStarExample() {
		assertEquals(0, this.getFloor("2015/01Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(1797, this.getMinusOne("2015/01.txt"));
	}
	

	@Test
	void secondStarExample() {
		assertEquals(4, this.getMinusOne("2015/01Example.txt"));
	}
}
