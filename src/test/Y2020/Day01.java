package test.Y2020;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day01 {

	private int getMultiplyResult(String filename) {
		int result = 0;
		List<String> lineOfStrings = FileReader.getLines(filename);
		for (int a = 0; a < lineOfStrings.size(); a++) {
			for (int b = 1; b < lineOfStrings.size(); b++) {
				for (int c = 2; c < lineOfStrings.size(); c++) {
					if (Integer.valueOf(lineOfStrings.get(a)) + Integer.valueOf(lineOfStrings.get(b)) + Integer.valueOf(lineOfStrings.get(c)) == 2020) {
						result = Integer.valueOf(lineOfStrings.get(a)) * Integer.valueOf(lineOfStrings.get(b)) * Integer.valueOf(lineOfStrings.get(c));
					}
				}
			}
		}
		return result;
	}
	
	@Test
	void firstStar() {
		assertEquals(195700142, getMultiplyResult("2020/01.txt"));
	}

	@Test
	void firstStarExample() {
		assertEquals(241861950, getMultiplyResult("2020/01Example.txt"));
	}

}
