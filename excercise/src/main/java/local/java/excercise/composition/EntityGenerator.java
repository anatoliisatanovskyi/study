package local.java.excercise.composition;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import local.java.excercise.filesio.ResourceReader;
import local.java.excercise.randomization.Randomizer;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;
import local.java.model.SourceConstant;

public class EntityGenerator {

	public static Company generateCompany() {
		Queue<String> companyNames = new LinkedList<>();
		Queue<String> departmentNames = new LinkedList<>();
		Queue<String> firstNames = new LinkedList<>();
		Queue<String> lastNames = new LinkedList<>();
		List<Integer> departmentEmployees = IntStream.range(0, Randomizer.randomizeInteger(3, 50)).boxed()
				.map(c1 -> Randomizer.randomizeInteger(2, 60)).collect(Collectors.toList());
		return generateCompany(companyNames, departmentNames, firstNames, lastNames, departmentEmployees);
	}

	public static Company generateCompany(Queue<String> companyNames, Queue<String> departmentNames,
			Queue<String> firstNames, Queue<String> lastNames, List<Integer> departmentEmployees) {
		return new Company(ensureCapacityAndPoll(companyNames, SourceConstant.COMPANY_NAMES),
				departmentEmployees.stream()
						.map(empCount -> generateDepartment(empCount, departmentNames, firstNames, lastNames))
						.collect(Collectors.toList()));
	}

	public static Department generateDepartment(int employeeCount, Queue<String> departmentNames,
			Queue<String> firstNames, Queue<String> lastNames) {
		return new Department(ensureCapacityAndPoll(departmentNames, SourceConstant.DEPARTMENT_NAMES),
				IntStream.range(0, employeeCount).boxed().map(v -> generateEmployee(firstNames, lastNames))
						.collect(Collectors.toList()));
	}

	public static Employee generateEmployee(Queue<String> firstNames, Queue<String> lastNames) {
		String firstName = ensureCapacityAndPoll(firstNames, SourceConstant.FIRST_NAMES);
		String lastName = ensureCapacityAndPoll(lastNames, SourceConstant.LAST_NAMES);
		return new Employee(firstName, lastName, Randomizer.randomizeBoolean() ? Sex.FEMALE : Sex.FEMALE,
				Randomizer.randomizeInteger(18, 70), Randomizer.randomizeDouble(1000.0, 8000.0, 2));
	}

	private static String ensureCapacityAndPoll(Queue<String> queue, String source) {
		if (queue.isEmpty())
			fillQueue(queue, source);
		return queue.poll();
	}

	private static void fillQueue(Queue<String> queue, String source) {
		@SuppressWarnings("unchecked")
		List<String> values = ResourceReader.readAsList(source);

		values = values.stream().map(s -> {
			s = s.trim();
			return s;
		}).collect(Collectors.toList());
		Collections.shuffle(values);
		queue.addAll(values);
	}
}
