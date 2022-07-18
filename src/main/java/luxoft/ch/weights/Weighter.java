package luxoft.ch.weights;

import java.util.ArrayList;
import java.util.List;

public class Weighter {

	record Solution(int leftNumber1, int leftNumber2, int rightNumber1, int rightNumber2) {
		@Override
		public String toString() {
			return "[%d,%d - %d,%d]".formatted(leftNumber1, leftNumber2, rightNumber1, rightNumber2);
		}
	}

	private final int bigWeight;
	private final int number1;
	private final int weight1;
	private final int number2;
	private final int weight2;

	public Weighter(int bigWeight, int number1, int weight1, int number2, int weight2) {
		this.bigWeight = bigWeight;
		this.number1 = number1;
		this.weight1 = weight1;
		this.number2 = number2;
		this.weight2 = weight2;
	}

	public List<Solution> solve() {
		List<Solution> solutions = new ArrayList<>();
		for (int number1Difference = 0; number1Difference <= number1; number1Difference++) {
			int number2Total = bigWeight - number1Difference * weight1;
			if (number2Total % weight2 == 0) {
				int number2Difference = number2Total / weight2;
				fillInSolutions(solutions, number1Difference, number2Difference);
			}
		}
		return solutions;
	}

	private void fillInSolutions(List<Solution> solutions, int number1Difference, int number2Difference) {
		for (int n1 = 0; n1 * 2 + number1Difference <= number1; n1++) {
			for (int n2 = 0; n2 * 2 + number2Difference <= number2; n2++) {
				solutions.add(new Solution(n1, n2, n1 + number1Difference, n2 + number2Difference));
			}
		}
	}

	public static void main(String... args) {
		long start = System.currentTimeMillis();
		var weighter = new Weighter(10000, 1000, 5, 400, 25);
		weighter.solve().stream().map(Solution::toString).forEach(System.out::println);
		System.out.printf("%nSolution found in %d msec%n", System.currentTimeMillis() - start);
	}

}
