package luxoft.ch.weights;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import luxoft.ch.weights.Weighter.Solution;

class WeighterTest {

	@Test
	void test() {
		var weighter = new Weighter(100, 10, 5, 4, 25);
		List<Solution> sample = List.of(new Solution(0, 0, 0, 4), new Solution(1, 0, 1, 4), new Solution(2, 0, 2, 4),
				new Solution(3, 0, 3, 4), new Solution(4, 0, 4, 4), new Solution(5, 0, 5, 4), new Solution(0, 0, 5, 3),
				new Solution(1, 0, 6, 3), new Solution(2, 0, 7, 3), new Solution(0, 0, 10, 2),
				new Solution(0, 1, 10, 3));
		Assertions.assertEquals(sample, weighter.solve());
	}

}
