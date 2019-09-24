package local.java.excercise.randomization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

/**
 * for the purposes of these tests - use class java.util.Random and it's methods
 * nextInt, nextDouble, etc...
 */
public class RandomizationTest {

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will randomize and return an integer value. Method must receive
	 * two parameters: int min, int max. Returned value must be in range between min
	 * and max
	 * 
	 * Generate 1000 values and store them to list. Check that none of the items are
	 * greater then max parameter
	 */
	@Test

	public void testRandomizeIntegerWithMinMaxValue() throws Exception {
		// TODO: implement
		List l = new ArrayList();
		int max = 100;

		for (int i = 0; i < 1000; i++) {
			l.add(Randomizer.randomizeInteger(1, max));
		}
		for (Object value : l) {
			assertFalse((int) value > max);

		}

	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will randomize and return an integer value. Method must not
	 * receive any parameters. Returned value can be any integer value. Tip: make
	 * use of Integer.MAX_VALUE
	 */
	@Test
	public void testRandomizeIntegerWithoutMinMaxValue() throws Exception {
		// TODO: implement
		List l = new ArrayList();
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < 100; i++) {
			l.add(Randomizer.randomizeInteger());

		}

		Iterator itr = l.iterator();
		while (itr.hasNext()) {
			assertTrue((int) itr.next() < Integer.MAX_VALUE);
		}

	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will randomize and return a double value. Method must receive
	 * three parameters: double min, double max, int precision. Return value must be
	 * in range between min and max. Return value must have digits after dot equal
	 * to precision, e.g: if generated value is 1234.56789 and precision=2 then
	 * return value is 1234.57. Tip: use Math.round method
	 * 
	 * Generate 1000 values and store them to list. Check that none of the items are
	 * greater then max parameter
	 */
	@Test
	public void testRandomizeDoubleWithMinMaxValue() throws Exception {
		// TODO: implement

		List l = new ArrayList();

		for (int i = 0; i < 1000; i++) {
			l.add(Randomizer.randomizeDoule(0, 100, 2));
		}
		for (Object d : l) {
			assertTrue((double) d < 100);
		}
	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will randomize and return a double value. Method must receive one
	 * parameter: int precision. Return value can be any double value. Tip: make use
	 * of Double.MAX_VALUE
	 */
	@Test
	public void testRandomizeDoubleWithoutMinMaxValue() throws Exception {
		// TODO: implement

		// Failed :(

		System.out.println(Randomizer.randomizeDouble(3));
	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will return a random boolean value
	 */
	@Test
	public void testRandomizeBoolean() throws Exception {
		// TODO: implement
		List l = new ArrayList();

		for (int i = 0; i < 100; i++) {
			l.add(Randomizer.randomBoolean());
		}

		Iterator itr = l.iterator();
		while (itr.hasNext()) {
			boolean b = (boolean) itr.next();
			if (b)
				assertTrue(b);
			else
				assertFalse(b);

		}
	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will generate and return a unique identifier java.util.UUID. In
	 * test generate a UUID and store to variable UUID uniqueId. Translate uniqueId
	 * to String and store to variable String textualUniqueId. Translate
	 * textualUniqueId back to UUID and check that it is equal to variable uniqueId.
	 * Tip: use UUID.randomUUID() and UUID.fromString methods
	 */
	@Test
	public void testGenerateUniqueId() throws Exception {
		// TODO: implement
	UUID uniqueId = Randomizer.randomUUID();
		String textualUniqueId = uniqueId.toString();
		UUID actual = UUID.fromString(textualUniqueId);
		assertEquals(uniqueId , actual);

	}
}
