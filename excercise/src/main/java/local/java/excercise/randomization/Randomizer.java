package local.java.excercise.randomization;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Randomizer {

	public static int randomizeInteger(int min, int max) {
		return new Random().nextInt(max + 1 - min) + min;
	}

	public static int randomizeInteger() {

		return randomizeInteger(0, Integer.MAX_VALUE);

	}

	public static boolean randomizeBoolean() {
		return new Random().nextBoolean();
	}

	public static double randomizeDouble(double min, double max, int precision) {
		return BigDecimal.valueOf(min + (max - min) * new Random().nextDouble())
				.setScale(precision, RoundingMode.HALF_UP).doubleValue();
	}
}
