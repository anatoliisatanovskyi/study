package local.java.excercise.aggregation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;

/**
 * To generate company objects use
 * local.java.excercise.composition.EntityGenerator
 */
public class AggregationTest {

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return count of all employees in all company departments. Method
	 * must take in one parameter: Company company.
	 */

	@Test
	public void testEmployeeCount() throws Exception {

		int actual;
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			int expected = 0;
			Collection<Department> depColection = c.getDepartments();
			for (Department d : depColection) {
				Collection<Employee> employeeCol = d.getEmployees();
				Iterator itr = employeeCol.iterator();

				while (itr.hasNext()) {
					itr.next();
					expected++;
				}

			}
			actual = Aggregator.employeeCount(c);
			assertEquals(expected, actual);
		}

	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return companies employee maximum salary. Method must take in one
	 * parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryMax() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			System.out.println(Aggregator.maxSalary(c));
		}

	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return companies employee minumum salary. Method must take in one
	 * parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryMin() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			System.out.println(Aggregator.minSalary(c));
		}
	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return an average salary of all employees in all company
	 * departments. Method must take in one parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryAverage() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			System.out.println("The avarage salary in company " + c.getName() + " is: " + Aggregator.avarageSalary(c));
		}
	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return an average salary of all male/female employees in all
	 * company departments. Method must take in two parameters: Company company, Sex
	 * sex.
	 */
	@Test
	public void testEmployeeSalaryAverageBySex() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			System.out.println(
					"The avarage salary in company " + c.getName() + " for: " + Sex.FEMALE.toString() + " " + Aggregator.avarageSalarySex(c, Sex.MALE));
		}
	}

	/**
	 * In class local.java.excercise.aggregation.Aggregator create a public static
	 * method that will look through a list of companies and count employees in
	 * departments with same name. Method must take in one parameter -
	 * List<Company>. Method must return Map<String,Integer> where key is department
	 * name and value is employee count.
	 */
	//Understand onlu dep = > count all employee
	@Test
	public void testEmployeeCountByDepartment() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
		Aggregator.countEmployeeInDepartaments(c);
	}
	}

	/**
	 * In class local.java.excercise.aggregation.Aggregator create a public static
	 * method that will look through a list of companies and find maximum salary for
	 * specific department. Method must take in two parameters: List<Company> companies,
	 * String departmentName. Method must return int for max salary.
	 */
//	Map<String, List<Department>>
//	map.get(searchName) -> departmentlist
 	@Test
	public void testEmployeeSalaryMaxByDepartment() throws Exception {
 		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
		Aggregator.maxSallaryInDepartments(c);
	}
 		
	}

	/**
	 * In class local.java.excercise.aggregation.Aggregator create a public static
	 * method that will look through a list of companies and find minimum salary for
	 * specific department. Method must take in two parameters: Company company,
	 * String departmentName. Method must return int for min salary.
	 */
	@Test
	public void testEmployeeSalaryMinByDepartment() throws Exception {
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
			Aggregator.minSallaryInDepartments(c).entrySet().forEach(System.out::println);
	}
	}
	
	@Test
	public void testToliaMinSallaryIndDepartments() throws Exception {
		String departmentName = "IT";
		List<Company> companies = EntityGenerator.generateCompanies();
		for (Company c : companies) {
		System.out.println("In company " + c.getName() + " minimum salary in " +departmentName + ": " + Aggregator.TolminSallaryInDepartments(c, "Accounting"));
	}
	}
}
