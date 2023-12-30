package test.Y2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Day03 {
	private int getOnesMinusZeros(List<String> report, int column) {
		int onesMinusZeros = 0;
		for (String line : report){
			if (Integer.valueOf(line.split("")[column]) == 0) {
				onesMinusZeros--;
			} else {
				onesMinusZeros++;
			}
		}
		return onesMinusZeros;
	}
	
	private List<Integer> getGammaDigits(String filename) {
		List<String> report = api.FileReader.getLines(filename);
		List<Integer> gammaDigits = new ArrayList<Integer>();
		for (int column = 0; column < report.get(0).length(); column++) {
			int onesMinusZeros = this.getOnesMinusZeros(report, column);
			gammaDigits.add((onesMinusZeros > 0) ? 1 : 0);
		}
		return gammaDigits;
	}

	private int fromBinary(List<Integer> digits) {
		int decimal = 0;
		int base = 1;
		for (int x = digits.size() - 1; x >= 0; x--) {
			decimal = digits.get(x) * base + decimal;
			base = base * 2;
		}
		return decimal;
	}
	
	private int getPowerConsumption(List<Integer> gammaDigits) {
		int gamma = this.fromBinary(gammaDigits);
		List<Integer> epsilonDigits = new ArrayList<Integer>();
		for (int x : gammaDigits) {
			epsilonDigits.add(1 - x);
		}
		int epsilon = this.fromBinary(epsilonDigits);
		return epsilon * gamma;
	}
	
	private List<Integer> getRating(List<String> report, int valueIfNonNegative) {
		List<String> rest = report;
		int column = 0;
		while (rest.size() > 1 && column < rest.get(0).length()) {
			List<String> newRest = new ArrayList<String>();
			int onesMinusZeros = this.getOnesMinusZeros(rest, column);
			int s = (onesMinusZeros >= 0) ? valueIfNonNegative : 1 - valueIfNonNegative;
				for (String line : rest) {
					if (Integer.valueOf(line.split("")[column]) ==  s){
						newRest.add(line);
					}
				}
			rest = newRest;
			column++;
		}
		List<Integer> digits = new ArrayList<Integer>();
		for (String digit : rest.get(0).split("")) {
			digits.add(Integer.valueOf(digit));
		}
		return digits;
	}
	
	private List<Integer> getOxygenRating(List<String> report) {
		return this.getRating(report, 1);
	}
	
	private List<Integer> getScrubberRating(List<String> report) {
		return this.getRating(report, 0);
	}
	
	private int getLifeSupportRating(String filename) {
		List<String> report = api.FileReader.getLines(filename);
		int scrubber = this.fromBinary(this.getScrubberRating(report));
		int oxygen = this.fromBinary(this.getOxygenRating(report));
		return scrubber * oxygen;
	}
		
	@Test
	void secondStarExample() {
		assertEquals(230, this.getLifeSupportRating("2021/03Example.txt"));
	}
	
	@Test
	void secondStar() {
		assertEquals(4550283, this.getLifeSupportRating("2021/03.txt"));
	}
	
	@Test
	void firstStarExample() {
		assertEquals(198, this.getPowerConsumption(getGammaDigits("2021/03Example.txt")));
	}
	
	@Test
	void firstStar() {
		assertEquals(3633500, this.getPowerConsumption(getGammaDigits("2021/03.txt")));
	}
}
