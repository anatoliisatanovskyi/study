package local.java.excercise.composition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import local.java.excercise.filesio.ResourceReader;
import local.java.excercise.randomization.Randomizer;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.SourceConstant;

public class EntityGenerator {
	
	public static Employee generateEmployee(Queue<String> firstNames, Queue<String> lastNames) {

		Employee employee = new Employee(QueueGenerator.pollfirstNames(), QueueGenerator.pollLastNames(),
				Randomizer.generateSex(), Randomizer.randomizeInteger(20, 60), Randomizer.randomizeDoule(500, 7000, 2));

		return employee;

	}

	public static Department generateDepartment(Queue<String> departmentNames, Queue<String> firstNames,
			Queue<String> lastNames) {
		List emploeesList = new ArrayList();

		int employees = Randomizer.randomizeInteger(5, 50);
		for (int i = 0; i < employees; i++) {
			emploeesList.add(generateEmployee(firstNames, lastNames));
		}

		Department department = new Department(QueueGenerator.poolDepNames(), emploeesList);

		return department;
	}

	public static List<Company> generateCompanies() {
		int count = Randomizer.randomizeInteger(5, 10);
		Queue<String> companyNames = new LinkedList<>();
		Queue<String> departmentNames = new LinkedList<>();
		Queue<String> qFirstNames = new LinkedList<>();
		Queue<String> qLastNames = new LinkedList<>();
		List<Company> companies = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			companies.add(generateCompany(companyNames, departmentNames, qFirstNames, qLastNames));
		}
		return companies;
	}

	private static Company generateCompany(Queue<String> companyNames, Queue<String> departmentNames,
			Queue<String> qFirstNames, Queue<String> qLastNames) {

		int count = Randomizer.randomizeInteger(4, 15);
		List<Department> departments = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			departments.add(generateDepartment(departmentNames, qFirstNames, qLastNames));

		}
		Company Mycompany = new Company(QueueGenerator.pollCompanyNames(), departments);

		return Mycompany;
	}

}
