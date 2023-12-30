package test.Y2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import api.FileReader;

class Day06 {
	
	private int getNumberOfFishes(String filename, int numberOfDays) {
		List<Integer> fishes = new ArrayList<Integer>();
		for (String numberAsString: FileReader.getLines(filename).get(0).split(",")) {
			fishes.add(Integer.valueOf(numberAsString));
		}
		for (int day = 1; day <= numberOfDays; day++) {
			for (int index = fishes.size() - 1; index >= 0; index--) {
				if (fishes.get(index) == 0) {
					fishes.set(index, 6);
					fishes.add(8);
				} else {
					fishes.set(index, fishes.get(index) - 1);
				}
			}
		}
		return fishes.size();
	}
	
	private long getBigNumberOfFishes(String filename, int numberOfDays) {
		Map<Integer,Long> timerNumber = new HashMap<Integer,Long>();
		for (String timerAsString: FileReader.getLines(filename).get(0).split(",")) {
			int timer = Integer.valueOf(timerAsString);
			Long number = timerNumber.get(timer);
			if (number == null) {
				timerNumber.put(timer, 1l);
			} else {
				timerNumber.put(timer, number + 1l);
			}
		}
		for (int day = 1; day <= numberOfDays; day++) {
			Map<Integer,Long> nextDayTimerNumber = new HashMap<Integer,Long>();
			for (int timer: timerNumber.keySet()) {
				long nextDayNumber = timerNumber.get(timer);
				int nextDayTimer;
				if (timer == 0) {
					nextDayTimer = 6;
					nextDayTimerNumber.put(8, nextDayNumber);
				} else {
					nextDayTimer = timer - 1;
				}
				Long nextDayPreviousNumber = nextDayTimerNumber.get(nextDayTimer);
				if (nextDayPreviousNumber != null) {
					nextDayNumber = nextDayPreviousNumber + nextDayNumber;
				}
				nextDayTimerNumber.put(nextDayTimer, nextDayNumber);
			}
			timerNumber = nextDayTimerNumber;
		}
		long totalNumber = 0;
		for (int timer: timerNumber.keySet()) {
			totalNumber = timerNumber.get(timer) + totalNumber;
		}
		return totalNumber;
	}

	@Test
	void firstStar() {
		assertEquals(374927, this.getNumberOfFishes("2021/06.txt", 80));
	}
	
	@Test
	void firstStarExample() {
		assertEquals(5934, this.getNumberOfFishes("2021/06Example.txt", 80));
	}
	
	@Test
	void firstStarQuickExample() {
		assertEquals(26, this.getNumberOfFishes("2021/06Example.txt", 18));
	}
	
	@Test
	void secondStar() {
		assertEquals(1687617803407l, this.getBigNumberOfFishes("2021/06.txt", 256));
	}
	@Test
	void firstStarWithProgrammSecondStar() {
		assertEquals(374927, this.getBigNumberOfFishes("2021/06.txt", 80));
	}
}
