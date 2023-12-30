package test.Y2021;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day01 {
	
	private List<Integer> getNumbers(String filename) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (String numberAsString: FileReader.getLines(filename)) {
			numbers.add(Integer.valueOf(numberAsString));
		}
		return numbers;
	}
	
	private int getHowManySumsBiggerThanPredecessor(int numbersPerSum, String filename) {
		List<Integer> numbers = this.getNumbers(filename);
		int howMany = 0;
		for (int y = 1 ; y <= numbers.size() - numbersPerSum ; y++) {
			if (numbers.get(y + numbersPerSum - 1) > numbers.get(y - 1)) {
				howMany++;
			}
		}
		return howMany;
	}
	
	private int getHowManyNumbersBiggerThanPredecessor(String filename) {
		List<Integer> numbers = this.getNumbers(filename);
		int howMany = 0;
		for (int y = 1 ; y < numbers.size() ; y++) {
			if (numbers.get(y) > numbers.get(y - 1)) {
				howMany++;
			}
		}
		return howMany;
	}
	
	private int getHowManySumsOfThreeBiggerThanPredecessor(String filename) {
		List<Integer> numbers = this.getNumbers(filename);
		int howMany = 0;
		for (int y = 1; y < numbers.size() - 2; y++) {
			if (numbers.get(y + 2) > numbers.get(y - 1)) {
				howMany++;
			}
		}
		return howMany;
	}
	
	@Test
	void firstStar() {
		assertEquals(1374, this.getHowManyNumbersBiggerThanPredecessor("2021/01.txt"));
	}

	@Test
	void exampleFirstStar() {
		assertEquals(7, this.getHowManyNumbersBiggerThanPredecessor("2021/01Example.txt"));
	}
	
	@Test
	void exampleSecondStar() {
		assertEquals(5, this.getHowManySumsOfThreeBiggerThanPredecessor("2021/01Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(1418, this.getHowManySumsOfThreeBiggerThanPredecessor("2021/01.txt"));
	}

	@Test
	void firstStarAlternative() {
		assertEquals(1374, this.getHowManySumsBiggerThanPredecessor(1, "2021/01.txt"));
	}
	
	@Test
	void secondStarAlternative() {
		assertEquals(1418, this.getHowManySumsBiggerThanPredecessor(3, "2021/01.txt"));
	}
	
}
