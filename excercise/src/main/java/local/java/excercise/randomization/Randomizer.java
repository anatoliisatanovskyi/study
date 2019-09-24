package local.java.excercise.randomization;

import java.util.Random;

public class Randomizer {

	public static int randomizeInteger(int min, int max) {

		Random r = new Random();
		return r.nextInt(max - min) + min;

	}
	
	public static int randomizeInteger() {

		return randomizeInteger(0, Integer.MAX_VALUE);
		

	}
	
	public static double randomizeDoule(double min, double max, int precision) {
		Random r = new Random();
		return (r.nextDouble() * max-min) + min;
	
	}

}
