package local.java.excercise.datapresentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;

public class CompanyView {

	public static List<Employee> filterFemaleInDepartment(Company company, String departmentName) {

		List<Department> filteredDepartments = filterWith(company.getDepartments(), new Condition<Department>() {
			@Override
			public boolean check(Department entity) {
				return entity.getName().contentEquals(departmentName);
			}
		});

		List<Employee> filteredEmployees = new ArrayList<>();
		for (Department department : filteredDepartments) {
			filteredEmployees.addAll(filterWith(department.getEmployees(), new Condition<Employee>() {
				@Override
				public boolean check(Employee entity) {
					return entity.getSex() == Sex.FEMALE;
				}
			}));
		}

		return filteredEmployees;
	}

	private static <T> List<T> filterWith(Collection<T> entities, Condition<T> condition) {
		List<T> checked = new ArrayList<>();
		for (T entity : entities) {
			if (condition.check(entity)) {
				checked.add(entity);
			}
		}
		return checked;
	}
}
