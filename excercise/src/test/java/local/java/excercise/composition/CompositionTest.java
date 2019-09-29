package local.java.excercise.composition;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import local.java.excercise.aggregation.Aggregator;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;

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

	@Test
	public void testName() throws Exception {
		Employee e1 = EntityGenerator.generateEmployee(new LinkedList<>(), new LinkedList<>());
		e1.setAge(20);
		e1.setSex(Sex.FEMALE);
		Employee e2 = EntityGenerator.generateEmployee(new LinkedList<>(), new LinkedList<>());
		e2.setAge(20);
		e2.setSex(Sex.MALE);
		Employee e3 = EntityGenerator.generateEmployee(new LinkedList<>(), new LinkedList<>());
		e3.setAge(20);
		e3.setSex(Sex.FEMALE);
		List<Employee> employees = Arrays.asList(e1, e2, e3);
		Map<SexAndAge, List<Employee>> map = new HashMap<>();
		Map<Sex, Map<Integer, List<Employee>>> map2 = new HashMap<>();
		for(Employee e : employees) {
			SexAndAge compound = new SexAndAge(e);
			map.putIfAbsent(compound, new ArrayList<>());
			map.get(compound).add(e);
			
			map2.putIfAbsent(e.getSex(), new HashMap<>());
			map2.get(e.getSex()).putIfAbsent(e.getAge(), new ArrayList<>());
			map2.get(e.getSex()).get(e.getAge()).add(e);
		}
		
		map.entrySet().forEach(System.out::println);
		System.out.println("***************");
		map2.entrySet().forEach(System.out::println);
	}

	// MALE -> 20 - > list
	class SexAndAge {

		Sex sex;
		Integer age;

		public SexAndAge(Employee employee) {
			this(employee.getSex(), employee.getAge());
		}

		public SexAndAge(Sex sex, Integer age) {
			this.sex = sex;
			this.age = age;
		}

		@Override
		public String toString() {
			return "SexAndAge [sex=" + sex + ", age=" + age + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((age == null) ? 0 : age.hashCode());
			result = prime * result + ((sex == null) ? 0 : sex.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SexAndAge other = (SexAndAge) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (age == null) {
				if (other.age != null)
					return false;
			} else if (!age.equals(other.age))
				return false;
			if (sex != other.sex)
				return false;
			return true;
		}

		private CompositionTest getEnclosingInstance() {
			return CompositionTest.this;
		}

		
	}
}