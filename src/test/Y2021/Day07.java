package test.Y2021;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import api.FileReader;

import org.junit.jupiter.api.Test;

class Day07 {

	private int getFuelCrabEngineering(int distance) {
		int fuel = 0;
		for (int a = 1; a <= distance; a++) {
			fuel += a;
		}
		return fuel;
	}
	
	private int getDistance(int startPosition, int endPosition) {
		if (startPosition >= endPosition) {
			return startPosition - endPosition;
		} else {
			return endPosition - startPosition;
		}
	}
	
	private int getHighestPosition(List<Integer> positions) {
		int highestPosition = Integer.MIN_VALUE;
		for (int position : positions) {
			if (position > highestPosition) {
				highestPosition = position;
			}
		}
		return highestPosition;
	}
	
	private int getLowestPosition(List<Integer> positions) {
		int lowestPosition = Integer.MAX_VALUE;
		for (int position : positions) {
			if (position < lowestPosition) {
				lowestPosition = position;
			}
		}
		return lowestPosition;
	}
	
	private int getMinFuelSum(String filename, boolean isFuelEqualToDistance) {
		List<Integer> positions = new ArrayList<Integer>();
		int minFuelSum = Integer.MAX_VALUE;
		for (String number : FileReader.getLines(filename).get(0).split(",")) {
			positions.add(Integer.valueOf(number));
		}
		int highestPosition = getHighestPosition(positions);
		for (int candidate = getLowestPosition(positions) ; candidate <= highestPosition ; candidate++) {
			int fuel = 0;
			for (int crab : positions) {
				int distance = getDistance(crab, candidate);
				if (isFuelEqualToDistance) {
					fuel += distance;
				} else {
					fuel += getFuelCrabEngineering(distance);
				}
			}
			if (fuel < minFuelSum) {
				minFuelSum = fuel;
			}
		}
		return minFuelSum;
	}
	
	@Test
	void fuelCrabEngineering() {
		assertEquals(55, getFuelCrabEngineering(10));
	}
	
	@Test
	void secondStar() {
		assertEquals(104149091, getMinFuelSum("2021/07.txt", false));
	}
	
	@Test
	void secondStarExample() {
		assertEquals(168, getMinFuelSum("2021/07Example.txt", false));
	}
	
	@Test
	void firstStar() {
		assertEquals(364898, getMinFuelSum("2021/07.txt", true));
	}

	@Test
	void firstStarExample() {
		assertEquals(37, getMinFuelSum("2021/07Example.txt", true));
	}
}
