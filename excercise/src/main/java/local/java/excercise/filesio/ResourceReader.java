package local.java.excercise.filesio;

import java.io.*;
import java.util.*;

public class ResourceReader {


	public static List readAsList(String path) {

		// creating new ArrayList object
		List l = new ArrayList();

		// creating new input from file
		// having problems with path. It works only with full path /User...
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(ResourceReader.class.getClassLoader().getResourceAsStream(path)))) {
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