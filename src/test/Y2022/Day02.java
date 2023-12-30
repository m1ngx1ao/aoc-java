package test.Y2022;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import api.FileReader;

public class Day02 {
	
	private Set<String> fromLettersToSet(String letters) {
		Set<String> set = new HashSet<String>();
		for (String letter : letters.split("")) {
			set.add(letter);
		}
		return set;
	}
	
	public int getPriorities(String filename) {
		List<String> allBackpack = FileReader.getLines(filename);
		int sumOfPriorities = 0;
		for (String twoBackpack : allBackpack) {
			int twoBackpackLength = twoBackpack.length() / 2;
			String one = twoBackpack.substring(0, twoBackpackLength);
			String two = twoBackpack.substring(twoBackpackLength);
			Set<String> setOne = fromLettersToSet(one);
			Set<String> setTwo = fromLettersToSet(two);
			setOne.retainAll(setTwo);
			String letter = setOne.iterator().next();
			int number = (int) letter.charAt(0);
			if (number > 96) {
				number = number - 96;
			} else {
				number = number - 38;
			}
			sumOfPriorities += number;
		}
		return sumOfPriorities;
	}
	
	
	@Test
	void firstStarExample() {
		assertEquals(157, this.getPriorities("2022/02Example.txt"));
	}
	
	@Test
	void firstStar() {
		assertEquals(8072, this.getPriorities("2022/02.txt"));
	}
	
	
	@Test
	void secondStarExample() {
	}
	
	@Test
	void secondStar() {
	}
	
}
