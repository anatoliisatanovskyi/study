package local.java.excercise.filesio;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class FilesIOTest {

	ResourceReader rr = new ResourceReader();

	/**
	 * in file local.java.excercise.filesio.ResourceReader create a public static
	 * method that will read resource file filesio/first_names.txt and return it's
	 * content as a List. additional: check that result list is not empty and
	 * contains 100 unique elements
	 */
	@Test
	public void testReadAndStoreFirstNames() throws Exception {

		String path = "filesio/first_names.txt";

		List actual = rr.readAsList(path);

		assertNotNull(actual);
		assertTrue(!actual.isEmpty());
		assertFalse(actual.isEmpty()); // or like this
		BufferedReader br = new BufferedReader(
				new InputStreamReader(ResourceReader.class.getClassLoader().getResourceAsStream(path)));
		long linesCount = 0;
		while (br.readLine() != null)
			linesCount++;
		assertEquals(actual.size(), linesCount);

		String names = ("Sherrill\n" + "Stevie\n" + "Brigida\n" + "Julietta\n" + "Audrea\n" + "Jaime\n" + "Luna\n"
				+ "Kala\n" + "Bethanie\n" + "Nannie\n" + "Mica\n" + "Rose\n" + "Jamey\n" + "Minh\n" + "Johnsie\n"
				+ "Leia\n" + "Natividad\n" + "Shizuko\n" + "Tommy\n" + "Amal\n" + "Jaquelyn\n" + "Margy\n" + "Belkis\n"
				+ "Dorinda\n" + "Malika\n" + "Ebonie\n" + "Darrin\n" + "Deena\n" + "Lory\n" + "Haywood\n" + "Modesto\n"
				+ "Saturnina\n" + "Tu\n" + "Shauna\n" + "Odis\n" + "Josef\n" + "Astrid\n" + "Layne\n" + "Janeth\n"
				+ "Jacqui\n" + "Vincent\n" + "Aubrey\n" + "Terisa\n" + "Dania\n" + "Celia\n" + "Lavette\n" + "Lavon\n"
				+ "Tracee\n" + "Iraida\n" + "Lawanda");

		List expected = Arrays.asList(names.split("\n"));

		assertEquals(expected, actual);

		// TODO: implement
		// assertEquals(expected, actual);
		// assertTrue(bool);
		// assertNotNull();
		// assertArrayEquals(exp, act);
	}

	/**
	 * use method from previous test to read and store to a list last names from
	 * file filesio/last_names.txt additional: check that result list is not empty
	 * and contains 100 unique elements
	 */
	@Test
	public void testReadAndStoreLastNames() throws Exception {
		// TODO: implement
		String path = "filesio/last_names.txt";
		List actual = rr.readAsList(path);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		BufferedReader br = new BufferedReader(
				new InputStreamReader(ResourceReader.class.getClassLoader().getResourceAsStream(path)));
		long linesCount = 0;
		while (br.readLine() != null)
			linesCount++;

		assertEquals(linesCount, actual.size());

		String lastNames = "Epping\n" + "Oliveira\n" + "Nicholson\n" + "Hackenberg\n" + "Lagunas\n" + "Kall\n"
				+ "Ruther\n" + "Ceron\n" + "Barley\n" + "Milardo\n" + "Guerro\n" + "Pino\n" + "Burks\n" + "Fly\n"
				+ "Hunt\n" + "Tibbets\n" + "Marchand\n" + "Brookshire\n" + "Childs\n" + "Claytor\n" + "Weis\n"
				+ "Radice\n" + "Paulk\n" + "Harger\n" + "Luthy\n" + "Kittleson\n" + "Gisler\n" + "Willcutt\n"
				+ "Stallone\n" + "Rimer\n" + "Galvin\n" + "Guild\n" + "Hosein\n" + "Rizer\n" + "Hurn\n" + "Sinkler\n"
				+ "Weyant\n" + "Noren\n" + "Debelak\n" + "Denton\n" + "Storlie\n" + "Thomure\n" + "Greene\n"
				+ "Gagliardi\n" + "Kuo\n" + "Bias\n" + "Mestayer\n" + "Koehler\n" + "Rodrigues\n" + "Zerr";
		List expected = Arrays.asList(lastNames.split("\n"));
		assertEquals(expected, actual);
		assertArrayEquals(expected.toArray(), actual.toArray());

	}

	@Test
	public void testReadCompanyNames() throws Exception {
		String path = "filesio/company_names.txt";
		List actual = rr.readAsList(path);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		BufferedReader br = new BufferedReader(
				new InputStreamReader(ResourceReader.class.getClassLoader().getResourceAsStream(path)));
		long linesCount = 0;
		while (br.readLine() != null)
			linesCount++;

		assertEquals(linesCount, actual.size());

		String companyNames = "Bovill \n" + "Yanix \n" + "Leevee \n" + "Yota \n" + "Locic \n" + "Perer \n" + "Enise \n"
				+ "Outise \n" + "Coramm \n" + "Kwizzy \n" + "Scizz \n" + "Corend \n" + "Autombu \n" + "Contracee \n"
				+ "Conile \n" + "Cryomba \n" + "Bellose \n" + "Poder \n" + "Jafy \n" + "Neoxo \n" + "Epivu \n"
				+ "Intravu \n" + "Megare \n" + "Infrare \n" + "Socimba \n" + "Alindo \n" + "Redoo \n" + "Subous \n"
				+ "Dieloo \n" + "Parape \n" + "Cynism \n" + "Geondo \n" + "Uberible \n" + "Syil \n" + "Eigen \n"
				+ "Mudel \n" + "Bonous \n" + "Nonosis \n" + "Suprafy";

		List expected = Arrays.asList(companyNames.split("\n"));

		assertEquals(expected, actual);

	}

	@Test
	public void testReadDepartmentNames() throws Exception {
		String path = "filesio/department_names.txt";
		List actual = rr.readAsList(path);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		BufferedReader br = new BufferedReader(
				new InputStreamReader(ResourceReader.class.getClassLoader().getResourceAsStream(path)));
		long linesCount = 0;
		while (br.readLine() != null)
			linesCount++;
		assertTrue(actual.size() == linesCount);

		String departmentNames = "Accounting\n" + "IT\n" + "Sales\n" + "Marketing\n" + "Advertising\n" + "Support\n"
				+ "HR\n" + "Logistics\n" + "Finance\n" + "Management\n" + "Public Relations";

		List expected = Arrays.asList(departmentNames.split("\n"));
		assertEquals(expected, actual);

	}

	// for help ==> to make quotes on names to add them to ArrayList
//	String[] arr = new String[] { "Sarah", "James", "Kostya" };
//	ArrayList l = new ArrayList();
//
//	for (String s : arr) {
//		StringBuffer sb = new StringBuffer(s);
//
//		l.add(sb.append("\"").insert(0, "\"").toString());
//
//	}
//	System.out.println(l);

}
