package local.java.excercise.filesio;

import org.junit.Test;

import static org.junit.Assert.*;


import java.util.*;

public class FilesIOTest {

	/**
	 * in file local.java.excercise.filesio.ResourceReader create a public static
	 * method that will read resource file filesio/first_names.txt and return it's
	 * content as a List. additional: check that result list is not empty and
	 * contains 100 unique elements
	 */
	@Test
	public void testReadAndStoreFirstNames() throws Exception {
		
		ResourceReader rr = new ResourceReader();
		
		ArrayList actual = rr.read();
		
		// is the any other method??
		
		ArrayList expected = new ArrayList(Arrays.asList( new String[] {"Sherrill", "Stevie", "Brigida", "Julietta", "Audrea", "Jaime", "Luna", "Kala", "Bethanie", "Nannie", "Mica", "Rose", "Jamey", "Minh", "Johnsie", "Leia", "Natividad", "Shizuko", "Tommy", "Amal", "Jaquelyn", "Margy", "Belkis", "Dorinda", "Malika", "Ebonie", "Darrin", "Deena", "Lory", "Haywood", "Modesto", "Saturnina", "Tu", "Shauna", "Odis", "Josef", "Astrid", "Layne", "Janeth", "Jacqui", "Vincent", "Aubrey", "Terisa", "Dania", "Celia", "Lavette", "Lavon", "Tracee", "Iraida", "Lawanda"})) ;
		assertEquals(expected, actual);
		assertTrue(!actual.isEmpty());
		assertTrue(actual.size() == 50);
		assertNotNull(actual);
		
		//what is the difference between Equals and ArrayEquals in my example?
		
		
		// TODO: implement
		//assertEquals(expected, actual);
		//assertTrue(bool);
		//assertNotNull();
		//assertArrayEquals(exp, act);
	}

	/**
	 * use method from previous test to read and store to a list last names from
	 * file filesio/last_names.txt additional: check that result list is not empty
	 * and contains 100 unique elements
	 */
	@Test
	public void testReadAndStoreLastNames() throws Exception {
		// TODO: implement
	}
}
