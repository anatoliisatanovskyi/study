package local.java.excercise.aggregation;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.*;
import java.util.*;
import local.java.model.Sex.*;

public class Aggregator {

	public static int employeeCount(Company company) {
		int employeeCount = 0;
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for (Employee e : employeeCollection) {
				employeeCount++;
			}
		}
		return employeeCount;
	}
// need to implement without ArrayList
	public static Employee maxSalary(Company company) {
		Employee winner = null;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			TreeSet allEmployee = new 	TreeSet(employeeCollection);
			winner = (Employee) allEmployee.last();
		}

		return winner;
	}
	
	public static Employee minSalary(Company company) {
		Employee winner = null;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			TreeSet allEmployee = new 	TreeSet(employeeCollection);
			winner = (Employee) allEmployee.first();
		}

		return winner;
	}
	
	public static double avarageSalary(Company company) {
		int allSalary = 0;
		int workersCount = 0;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for ( Employee e: employeeCollection) {
				allSalary += e.getSalary();
				workersCount++;
			}
			
		}

		return allSalary / workersCount ;
	}
	
	
	public static double avarageSalarySex(Company company, Sex sex) {
		int allSalary = 0;
		int workersCount = 0;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for ( Employee e: employeeCollection) {
				if (e.getSex() == sex) {
					allSalary += e.getSalary();
					workersCount++;
				}
				
			}
			
		}

		return allSalary / workersCount ;
	}
	
	

}
