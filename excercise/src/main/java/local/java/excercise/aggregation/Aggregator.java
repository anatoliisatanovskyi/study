package local.java.excercise.aggregation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;

public class Aggregator {

	public static int getEmployeeCount(Company company) {
		return getCompanyEmployees(company).size();
	}

	public static List<Double> getEmployeeSalaries(Company company) {
		return getCompanyEmployees(company).stream().map(Employee::getSalary).sorted().collect(Collectors.toList());
	}
	
	public static List<Employee> getCompanyEmployees(Company company) {
		return company.getDepartments().stream().map(Department::getEmployees).collect(ArrayList::new, List::addAll,
				List::addAll);
	}
}
