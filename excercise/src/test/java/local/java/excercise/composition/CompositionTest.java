package local.java.excercise.composition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

import local.java.excercise.aggregation.Aggregator;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;

public class CompositionTest {

	/**
	 * In class local.java.excercise.composition.EntityGenerator create methods:
	 * 
	 * public static Employee generateEmployee(Queue <String> firstNames,
	 * Queue<String> lastNames) public static Department generateDepartment(int
	 * employees) public static Company generateCompany(List<Integer>
	 * departmentEmployees)
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
		int depCount = 0;
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			System.out.print("Company " + c.getName() + " has: " + Aggregator.employeeCount(c) + " employee, in: ");
			Collection<Department> depColection = c.getDepartments();
			for (Department d : depColection) {
				depCount++;
			}
			System.out.print(depCount + " departments\n");

		}

	}

	/**
	 * Using generation method from previous test generate 2+ companies with 3+
	 * departments with 4+ employees in each. Make sure that all companies are
	 * unique. Make sure that no employee is working in both companies.
	 */
	@Test
	public void testGenerateAndValidateCompanyUniqueness() throws Exception {
		int coundEmployee = 0;
		List<Company> companies = EntityGenerator.generateCompanies();
		List<Employee> allEmployees = new ArrayList();
		for (Company c : companies) {
			Collection<Department> depColection = c.getDepartments();
			for (Department d : depColection) {
				Collection<Employee> employeeCol = d.getEmployees();
				Iterator itr = employeeCol.iterator();
				while (itr.hasNext()) {
					allEmployees.add((Employee) itr.next());
					coundEmployee++;
				}

			}

		}

		boolean trig = false;
		for (Employee whatEmployee : allEmployees) {
			int count = 0;
			for (Employee toEmployee : allEmployees) {
				if (whatEmployee.equals(toEmployee)) {
					// System.out.println(count + " whatEmployee = " + whatEmployee + " toEmployee =
					// " + toEmployee);
					count++;
				}

			}
			if (count >= 2)
				trig = true;

		}
		assertFalse(trig);

	}
}
