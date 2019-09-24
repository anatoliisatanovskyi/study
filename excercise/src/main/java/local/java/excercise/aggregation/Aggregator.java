package local.java.excercise.aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;

public class Aggregator {

	public static int getEmployeeCount(Company company) {
		return getCompanyEmployees(company).size();
	}

	public static double getEmployeeCount(Collection<Company> companies) {
		return companies.stream().mapToInt(Aggregator::getEmployeeCount).sum();
	}

	public static List<Employee> getCompanyEmployees(Company company) {
		return company.getDepartments().stream().map(Department::getEmployees).collect(ArrayList::new, List::addAll,
				List::addAll);
	}

	public static double getEmployeeSalarySumm(Company company) {
		return getCompanyEmployees(company).stream().mapToDouble(Employee::getSalary).sum();
	}

	public static double getEmployeeSalarySumm(Collection<Company> companies) {
		return companies.stream().mapToDouble(Aggregator::getEmployeeSalarySumm).sum();
	}

	public static double getAverageSalary(Company company) {
		return getEmployeeSalarySumm(company) / getEmployeeCount(company);
	}
	
	public static double getAverageSalary(Collection<Company> companies) {
		return getEmployeeSalarySumm(companies) / getEmployeeCount(companies);
	}

	public static int getDepartmentsCount(Company company) {
		return company.getDepartments().size();
	}

	public static int getDepartmentsCount(Collection<Company> companies) {
		return companies.stream().map(Company::getDepartments).collect(ArrayList::new, List::addAll, List::addAll)
				.size();
	}
}
