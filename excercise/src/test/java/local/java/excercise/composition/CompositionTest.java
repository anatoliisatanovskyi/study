package local.java.excercise.composition;

import org.junit.Test;

public class CompositionTest {

	/**
	 * In class local.java.excercise.composition.EntityGenerator create methods:
	 * 
	 * public static Employee generateEmployee(Queue <String> firstNames, Queue<String> lastNames) public static Department
	 * generateDepartment(int employees) public static Company
	 * generateCompany(List<Integer> departmentEmployees)
	 * 
	 * These methods must generate and return random entity objects. To fill fields
	 * Employee.firstName, Employee.lastName, Department.name, Company.name read and
	 * use values from files filesio/first_names.txt, filesio/last_names.txt,
	 * filesio/company_names.txt, filesio/department_names.txt and use utility class
	 * local.java.excercise.filesio.ResourceReader. To generate all other fields use
	 * methods from utility class local.java.excercise.randomization.Randomizer.
	 * 
	 */
	@Test
	public void testGenerateCompany() throws Exception {

	}

	/**
	 * Using generation method from previous test generate 2+ companies with 3+
	 * departments with 4+ employees in each. Make sure that all companies are
	 * unique. Make sure that no employee is working in both companies.
	 */
	@Test
	public void testGenerateAndValidateCompanyUniqueness() throws Exception {

	}
}
