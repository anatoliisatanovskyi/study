package local.java.excercise.aggregation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Before;
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
	List<Company> companies;
	List<Department> departments;
	Department department;
	Company company;

	@Before
	public void entetyLoad() {

		List<Company> companies = EntityGenerator.generateCompanies();
		company = companies.stream().findFirst().get();
		departments = companies.stream().flatMap(c -> c.getDepartments().stream()).collect(Collectors.toList());
		department = departments.parallelStream().findAny().get();

	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return count of all employees in all company departments. Method
	 * must take in one parameter: Company company.
	 */

	@Test
	public void testMinSalaryInDepartment() {
		TreeSet<Employee> set = new TreeSet<Employee>((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));

		set.addAll(department.getEmployees());

		double expected = set.first().getSalary();
		assertEquals(expected, Aggregator.minSalaryInDepartment(department), 0.01);
	}

	@Test
	public void testmaxSalaryInDepartment() {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		set.addAll(department.getEmployees());
		double expected = set.last().getSalary();
		assertEquals(expected, Aggregator.maxSalaryInDepartment(department), 0.2);
	}

	@Test
	public void testGetEmployees() throws Exception {
		List<Employee> employees = new ArrayList<>();
		for (Department d : departments) {
			employees.addAll(d.getEmployees());
		}
		assertEquals(employees, Aggregator.getEmployees(departments));
	}

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

	@Test
	public void testMyDelete() throws Exception {
		Company c;
		List<Company> listOfCompanies = EntityGenerator.generateCompanies();
		c = listOfCompanies.get(0);
		Aggregator ag = new Aggregator();
		ag.getEmployees(c.getDepartments());

	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return companies employee maximum salary. Method must take in one
	 * parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryMax() throws Exception {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		set.addAll(Aggregator.getEmployees(departments));
		set.last();
		assertEquals(set.last(), Aggregator.maxSalary(departments));
	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return companies employee minumum salary. Method must take in one
	 * parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryMin() throws Exception {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		set.addAll(Aggregator.getEmployees(company));

		assertEquals(set.first(), Aggregator.minSalary(company));
	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return an average salary of all employees in all company
	 * departments. Method must take in one parameter: Company company.
	 */
	@Test
	public void testEmployeeSalaryAverage() throws Exception {
		double allSalary = 0;
		int workersCount = 0;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for (Employee e : employeeCollection) {
				allSalary += e.getSalary();
				workersCount++;
			}

		}

		double expected = (int) allSalary / workersCount;
		assertEquals(expected, Aggregator.avarageSalary(company), 0.01);
	}

	/**
	 * In local.java.excercise.aggregation.Aggregator create a public static method
	 * that will return an average salary of all male/female employees in all
	 * company departments. Method must take in two parameters: Company company, Sex
	 * sex.
	 */
	@Test
	public void testAvarageSalarySex() throws Exception {
		double allSalary = 0;
		int workersCount = 0;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for (Employee e : employeeCollection) {
				if (e.getSex() == Sex.FEMALE) {
					allSalary += e.getSalary();
					workersCount++;
				}
			}
		}
		double expected = Math.round(allSalary) / workersCount;
		assertEquals(expected, Aggregator.avarageSalarySex(company, Sex.FEMALE), 0.1);
	}

	/**
	 * In class local.java.excercise.aggregation.Aggregator create a public static
	 * method that will look through a list of companies and count employees in
	 * departments with same name. Method must take in one parameter -
	 * List<Company>. Method must return Map<String,Integer> where key is department
	 * name and value is employee count.
	 */
	// Understand onlu dep = > count all employee
	@Test
	public void testEmployeeCountByDepartment() throws Exception {
		List<Company> countEmployeeInDepartaments = EntityGenerator.generateCompanies();
		Aggregator.countEmployeeInDepartaments(countEmployeeInDepartaments);

//		List l = new ArrayList();
//		for( int i = 0; i < 10; i++) {
//			l.add(i);
//			l.add(2);
//			System.out.println(l);
//		}
//		Set set = new HashSet();
//		set.addAll(l);
//		System.out.println(set);

	}

	/**
	 * In class local.java.excercise.aggregation.Aggregator create a public static
	 * method that will look through a list of companies and find maximum salary for
	 * specific department. Method must take in two parameters: List<Company>
	 * companies, String departmentName. Method must return int for max salary.
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
			System.out.println("In company " + c.getName() + " minimum salary in " + departmentName + ": "
					+ Aggregator.TolminSallaryInDepartments(c, "Accounting"));
		}
	}
}
