package test.Y2022;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import api.FileReader;

public class Day01 {
	
	public int getCalories(String filename) {
		int jackpot = 0;
		int elfCalorie = 0;
		for (String calorie : FileReader.getLines(filename)) {
			if (calorie.equals("")) {
				elfCalorie = 0;
			} else {
				elfCalorie += Integer.valueOf(calorie);
				if (elfCalorie > jackpot) {
					jackpot = elfCalorie;
				}
			}
		}
		return jackpot;
	}
	
	public int getFirstThreeCalories(String filename) {
		List<String> numbers = FileReader.getLines(filename);
		numbers.add("");
		List<Integer> calories = new ArrayList<Integer>();
		int elfCalorie = 0;
		for (String calorie : numbers) {
			if (calorie.equals("")) {
				calories.add(elfCalorie);
				elfCalorie = 0;
			} else {
				elfCalorie += Integer.valueOf(calorie);
			}
		}
		Collections.sort(calories);
		Collections.reverse(calories);
		return calories.get(0) + calories.get(1) + calories.get(2);
	}
	
	@Test
	void firstStarExample() {
		assertEquals(24000, this.getCalories("2022/01Example.txt"));
	}
	
	@Test
	void firstStarPExample() {
		assertEquals(300, this.getCalories("2022/01PExample.txt"));
	}
	
	@Test
	void firstStar() {
		assertEquals(68442, this.getCalories("2022/01.txt"));
	}
	
	
	@Test
	void secondStarExample() {
		assertEquals(45000, this.getFirstThreeCalories("2022/01Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(204837, this.getFirstThreeCalories("2022/01.txt"));
	}
	
}
