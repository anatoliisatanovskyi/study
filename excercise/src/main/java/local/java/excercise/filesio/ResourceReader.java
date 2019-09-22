package local.java.excercise.filesio;

import java.io.*;
import java.util.*;

public class ResourceReader {

	private static final Random r = new Random();

	public static ArrayList read() {

		// creating new ArrayList object
		ArrayList l = new ArrayList();

		// creating new input from file
		//having problems with path. It works only with full path /User...
		try (BufferedReader br = new BufferedReader(
				new FileReader("/Users/neil/Documents/sources/exercise/excercise/src/main/resources/filesio/first_names.txt"))) {
			String s;
			while ((s = br.readLine()) != null) {
				l.add(s);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return l;

	}

}