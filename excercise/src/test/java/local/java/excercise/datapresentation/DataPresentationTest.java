package local.java.excercise.datapresentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.Company;
import local.java.model.CompanyRateing;
import local.java.model.RateingType;

/**
 * To generate company objects use
 * local.java.excercise.composition.EntityGenerator
 */
public class DataPresentationTest {

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<String> fetchDepartmentNames(List<Company> companies). Method
	 * must return a list that will contain all of the companies department names.
	 * Returned list may contain duplicates.
	 */
	@Test
	public void testGetDepartmentNames() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<String> fetchUniqueDepartmentNames(List<Company> companies).
	 * Method must return a list that will contain all of the companies department
	 * names. Returned list must not contain duplicates.
	 */
	@Test
	public void testGetUniqueDepartmentNames() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<String> fetchEmployeeFullNamesInAlphabeticalOrder(List<Company>
	 * companies). Method must return a list that will contain all of the companies
	 * employee full names(first and last name as a single string).
	 */
	@Test
	public void testGetEmployeeFullNamesInAlphabeticalOrder() throws Exception {

	}

	/**
	 * Create an implementation of interface
	 * local.java.excercise.datapresentation.Condition that will check that given
	 * employees age is lower then or equal to a certain boundary. Implementation
	 * class must have a constructor that will take in(and set as a class field) an
	 * int value that will be the boundary for condition check. Method 'check' for
	 * this implementation must return true if employee.age <= boundary, otherwise -
	 * false.
	 * 
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<Employee> filterYoungerThen(Collection<Employee> employees, int
	 * maxAge). This method must return a list of employees who's age is lower then
	 * or equal to maxAge. For this operation use: implementation of Condition from
	 * previous step; method filterWith that is inside CompanyView.
	 */
	@Test
	public void testGetEmployeesWithSalaryFilter() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<Employee> filterMaleOlderThen(Collection<Employee> employees, int
	 * minAge). Create a new implementation of Condition that will return true in
	 * case employee.sex == MALE and employee.age >= minAge. As previously - use
	 * method filterWith that is inside CompanyView.
	 */
	@Test
	public void testGetMaleEmployeesWithAgeFilter() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static List<Employee> filterFemaleInDepartment(Company company, String
	 * departmentName). Create two implementations of Condition. First one will
	 * return true if department.name is equal to departmentName. Second
	 * implementation will return true if employee.sex == FEMALE. Use these
	 * implementations in new method 'filterFemaleInDepartment' to return all female
	 * employees of the company in specific department.
	 */
	@Test
	public void testGetFemaleEmployeesWithDepartmentFilter() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<String, Integer> groupDepartmentCountByCompany(Collection<Company>
	 * companies). Key for the return map will be department.name. Value is count of
	 * how many departments with key are in companies list, e.g: if a list contains
	 * only one company that has 'IT' department - then map will contain an entry
	 * 'IT' : 1. If a list contains two departments with name 'Accounting', then map
	 * will contain entry 'Accounting' : 2, etc.
	 */
	@Test
	public void testGroupDepartmentCountByCompany() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<String, List<String>>
	 * groupDepartmentNamesByCompany(Collection<Company> companies). Key for the
	 * return map will be company.name. Value is List<String> that will contain all
	 * department names of this company.
	 */
	@Test
	public void testGroupDepartmentNamesByCompany() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<String, Integer>
	 * groupEmployeeCountByDepartment(Collection<Company> companies). Key for the
	 * return map will be department.name. Value is count of employees in this
	 * department. Be aware that multiple companies may have departments with same
	 * name. In this case count value must be a sum of employees of such
	 * departments.
	 */
	@Test
	public void testGroupEmployeeCountByDepartment() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<Integer, Integer> groupEmployeeCountByAge(Collection<Company>
	 * companies). Key for the return map will be employee.age. Value is count of
	 * employees with this age.
	 */
	@Test
	public void testGroupEmployeeCountByAge() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<String, List<Employee>>
	 * groupEmployeesByDepartment(Collection<Company> companies). Key for the return
	 * map will be department.name. Value is List<Employee> that will contain all
	 * employees that work in departments with this name.
	 */
	@Test
	public void testGroupEmployeesByDepartment() throws Exception {

	}

	/**
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<Sex, Map<Integer, Integer>>
	 * groupEmployeeCountBySexAndAgeUsingNestedMap(Collection<Company> companies).
	 * The return value for this method is a map of maps (nested map). Map key is
	 * Sex, nested map key is age and value is count of employees for these sex and
	 * age.
	 */
	@Test
	public void testGroupEmployeeCountBySexAndAgeUsingNestedMap() throws Exception {

	}

	/**
	 * Create a class SexAndAge that will have two class fields: Sex sex, Integer
	 * age. Override hashCode and equals method for this class.
	 * 
	 * In local.java.excercise.datapresentation.CompanyView create a method public
	 * static Map<SexAndAge, Integer>
	 * groupEmployeeCountBySexAndAgeUsingCompoundKey(Collection<Company> companies).
	 * The return value is a map with compound key SexAndAge. Value is count of
	 * employees for these sex and age.
	 */
	@Test
	public void testGroupEmployeeCountBySexAndAgeUsingCompoundKey() throws Exception {

	}
}
