package local.java.excercise.composition;

import java.util.*;

import local.java.excercise.filesio.ResourceReader;
import local.java.model.SourceConstant;

public class QueueGenerator {

	private static Queue<String> firstNames = new LinkedList<>();
	private static String firstNamesPath = SourceConstant.FIRST_NAMES;

	private static Queue<String> lastNames = new LinkedList<>();
	private static String lastNamesPath = SourceConstant.LAST_NAMES;

	private static Queue<String> depNames = new LinkedList<>();
	private static String depNamestNamesPath = SourceConstant.DEPARTMENT_NAMES;

	private static Queue<String> companyNames = new LinkedList<>();
	private static String companyNamesPath = SourceConstant.COMPANY_NAMES;

	public static String pollfirstNames() {
		return poolFrom(firstNames, firstNamesPath);
	}
	
	public static String pollLastNames() {
		return poolFrom(lastNames, lastNamesPath);
	}
	
	public static String poolDepNames() {
		return poolFrom(depNames, depNamestNamesPath);
	}
	
	public static String pollCompanyNames() {
		return poolFrom(companyNames, companyNamesPath);
	}
	
	public static String poolFrom(Queue<String> queue, String path) {

		if (queue.isEmpty()) {
			queue.addAll(ResourceReader.readAsList(path));
		}
		return queue.poll();
	}

}
