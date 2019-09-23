package local.java.excercise.randomization;

import java.util.Random;

public class Randomizer {

	public static int randomizeInteger(int min, int max) {

		Random r = new Random(max - min);
		return r.nextInt() + min;

	}
	
	public static int randomizeInteger() {

		return randomizeInteger(0, Integer.MAX_VALUE);
		

	}

}
