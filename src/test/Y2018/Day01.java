package test.Y2018;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day01 {

	private static int getResultOfPlusOrMinus(String filename) {
		int result = 0;
		for (String lineAsString: FileReader.getLines(filename)) {
			String[] numbers = lineAsString.split(" ");
			if (numbers[0].equals("+")) {
				result = result + Integer.valueOf(numbers[1]);
			}
			if (numbers[0].equals("-")) {
				result = result - Integer.valueOf(numbers[1]);
			}
		}
		return result;
	}
	
	@Test
	void firstStar() {
		assertEquals(522, getResultOfPlusOrMinus("2018/01.txt"));
	}

	@Test
	void firstStarExample() {
		assertEquals(0, getResultOfPlusOrMinus("2018/01Example.txt"));
	}
}
