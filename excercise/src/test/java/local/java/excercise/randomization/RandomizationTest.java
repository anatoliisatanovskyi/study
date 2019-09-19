package local.java.excercise.randomization;

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
	}

	/**
	 * In class local.java.excercise.randomization.Randomizer create a public static
	 * method that will return a random boolean value
	 */
	@Test
	public void testRandomizeBoolean() throws Exception {
		// TODO: implement
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
	}
}
