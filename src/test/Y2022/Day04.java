package test.Y2022;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import api.FileReader;

public class Day04 {
	
	public List<Integer> getNumbers(String line) {
		List<Integer> numbers = new ArrayList<Integer>();
		String[] orders = line.split(",");
		for (String order : orders) {
			String[] stringNumbers = order.split("-");
			for (String number : stringNumbers) {
				numbers.add(Integer.valueOf(number));
			}
		}
		return numbers;
	}

	public int howOftenDoubleTime(String filename) {
		int doubleTime = 0;
		for (String lineAsString: FileReader.getLines(filename)) {
			List<Integer> numbers = getNumbers(lineAsString);
			if ((numbers.get(0) <= numbers.get(2) &&
					numbers.get(1) >= numbers.get(3)) ||
					(numbers.get(2) <= numbers.get(0) &&
					numbers.get(3) >= numbers.get(1))
					) {
				doubleTime++;
			}
		}
		return doubleTime;
	}

	public int howOftenOverlap(String filename) {
		int overlapTimes = 0;
		for (String lineAsString: FileReader.getLines(filename)) {
			List<Integer> numbers = getNumbers(lineAsString);
			if ((numbers.get(2) <= numbers.get(1) &&
					numbers.get(3) >= numbers.get(0))
					) {
				overlapTimes++;
			}
		}
		return overlapTimes;
	}
	
	@Test
	void firstStarExample() {
		assertEquals(2, this.howOftenDoubleTime("2022/04Example.txt"));
	}
	
	@Test
	void firstStar() {
		assertEquals(441, this.howOftenDoubleTime("2022/04.txt"));
	}
	
	@Test
	void secondStarExample() {
		assertEquals(4, this.howOftenOverlap("2022/04Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(861, this.howOftenOverlap("2022/04.txt"));
	}
}
