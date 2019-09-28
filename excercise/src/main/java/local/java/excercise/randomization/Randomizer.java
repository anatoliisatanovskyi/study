package local.java.excercise.randomization;

import java.util.*;
import java.util.Random;
import java.util.UUID;

import local.java.model.Sex;

public class Randomizer {

	static Random r = new Random();

	public static int randomizeInteger(int min, int max) {

		return r.nextInt(max - min) + min;

	}

	public static int randomizeInteger() {

		return randomizeInteger(0, Integer.MAX_VALUE);

	}

	public static double randomizeDoule(double min, double max, int precision) {

		double mult = 1;
		for (int i = 0; i < precision; i++) {
			mult *= 10;
		}

		return Math.round(((r.nextDouble() * max - min) + min) * mult) / mult;

	}

// ******************
	// Do not Work :(
	public static double randomizeDouble(int precision) {

		return randomizeDoule(0, Double.MAX_VALUE, precision);
	}

	// ****************

	public static boolean randomBoolean() {

		return r.nextBoolean();

	}

	public static UUID randomUUID() {

		return UUID.randomUUID();
	}

	public static Sex generateSex() {
boolean sexb = 	randomBoolean();
		if (sexb) return Sex.FEMALE;
		else return Sex.MALE;
	
	}

	public static Queue queueGenerator(List l) {

		Queue queue = new PriorityQueue(l);

		return queue;
	}

}
