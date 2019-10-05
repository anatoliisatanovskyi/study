package local.java.excercise.datapresentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import local.java.excercise.aggregation.Aggregator;
import local.java.model.Company;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.Sex;

public class CompanyView {

	private static <T> List<T> filterWith(Collection<T> entities, Condition<T> condition) {
		List<T> checked = new ArrayList<>();
		for (T entity : entities) {
			if (condition.check(entity)) {
				checked.add(entity);
			}
		}
		return checked;
	}

	public static List<Employee> filterByMaleAgeGreaterThan(Collection<Employee> employees, int minAge) {
		List<Employee> filtered = new ArrayList<>();
		EmployeeMaleAgeCondition condition = new EmployeeMaleAgeCondition(minAge);

		filtered = filterWith(employees, condition);
//		for (Employee e : employees) {
//			if (condition.check(e)) {
//				filtered.add(e);
//			}
//		}

		return filtered;
	}

	public static List<Employee> filterFemaleInDepartment(Company company, String departmentName) {
		List<Employee> filter = new ArrayList<>();
		DepartmentNameCondition condition = new DepartmentNameCondition(departmentName);
		EmployeeFemaleCondition female = new EmployeeFemaleCondition();

		for (Department d : company.getDepartments()) {
			if (condition.check(d)) {
				filter = filterWith(d.getEmployees(), female);
			}

		}

		return filter;
	}

	// Review this ******
	public static Map<String, Integer> groupDepartmentCountByCompany(Collection<Company> companies) {
		Map<String, Integer> map = new HashMap<>();

		for (Company c : companies) {
			Integer count = 1;
			for (Department d : c.getDepartments()) {
				if (map.containsKey(d.getName())) {
					map.put(d.getName(), map.get(d.getName()) + 1);
				}
				map.putIfAbsent(d.getName(), count);
			}

		}

		return map;
	}

	public static Map<String, List<String>> groupDepartmentNamesByCompany(Collection<Company> companies) {

		Map<String, List<String>> map = new HashMap<>();

		for (Company c : companies) {

			for (Department d : c.getDepartments()) {
				map.putIfAbsent(c.getName(), new ArrayList<String>());
				map.get(c.getName()).add(d.getName());
			}
		}

		return map;

	}

//need to write a new method for this one. Get allEmployee in  Aggregation - not exactly it.
	public static Map<String, Integer> groupEmployeeCountByDepartment(Collection<Company> companies) {
		Map<String, Integer> map = new HashMap<>();
		for (Company c : companies) {
			for (Department d : c.getDepartments()) {
				if (map.containsKey(d.getName())) {
					map.put(d.getName(), map.get(d.getName()) + d.getEmployees().size());
				}
				map.putIfAbsent(d.getName(), d.getEmployees().size());

			}
		}
		return map;
	}

	public static Map<Integer, Integer> groupEmployeeCountByAge(Collection<Company> companies) {

		Map<Integer, Integer> map = new HashMap<>();
		List<Employee> l = new ArrayList<>();

		for (Company c : companies) {

			l = Aggregator.getEmployees(c);

			for (Employee e : l) {

				if (map.containsKey(e.getAge())) {
					map.put(e.getAge(), map.get(e.getAge()) + 1);

				}

				map.putIfAbsent(e.getAge(), 1);
			}

		}

		return map;
	}

	public static Map<String, List<Employee>> groupEmployeesByDepartment(Collection<Company> companies) {

		Map<String, List<Employee>> map = new HashMap<>();

		for (Company c : companies) {

			for (Department d : c.getDepartments()) {

				map.putIfAbsent(d.getName(), new ArrayList<>());
				map.get(d.getName()).addAll(d.getEmployees());
			}

		}
		return map;

	}

	public static List<Employee> filterByAge(Collection<Employee> employees, int maxAge) {

		EmployeeAgeCondition condition = new EmployeeAgeCondition(maxAge);
		return filterWith(employees, condition);
		// return filterWith(employees, new Condition<Employee>() {
		// @Override
		// public boolean check(Employee entity) {
		// return entity.getAge() <= maxAge;
		// }
		// });
	}

	public static List<String> fetchDepartmentNames(List<Company> companies) {
		List<String> departmentNames = new ArrayList<>();
		for (Company c : companies) {
			Collection<Department> departments = c.getDepartments();
			for (Department d : departments) {
				departmentNames.add(d.getName());
			}
		}
		return departmentNames;
	}

	public static List<String> fetchUniqueDepartmentNames(List<Company> companies) {
		List<String> departmentNames = new ArrayList<>();
		Set<String> unicDepNames = new TreeSet<>();
		for (Company c : companies) {
			Collection<Department> departments = c.getDepartments();
			for (Department d : departments) {
				unicDepNames.add(d.getName());
			}
			departmentNames.addAll(unicDepNames);

		}

		System.out.println(unicDepNames.size());
		return departmentNames;
	}

	public static List<String> fetchEmployeeFullNamesInAlphabeticalOrder(List<Company> companies) {
		List<String> allEmployeeNames = new ArrayList<>();
		for (Company c : companies) {
			List<Department> d = new ArrayList<>(c.getDepartments());
			for (Department dep : d) {
				List<Employee> emp = new ArrayList<>(dep.getEmployees());
				for (Employee e : emp) {
					allEmployeeNames.add(e.getFullName());
				}

			}

		}
		Collections.sort(allEmployeeNames);

		return allEmployeeNames;
	}

	public static Map<Sex, Map<Integer, Integer>> groupEmployeeCountBySexAndAgeUsingNestedMap(
			Collection<Company> companies) {
		Map<Sex, Map<Integer, Integer>> map = new HashMap<>();

		for (Company c : companies) {

			for (Department d : c.getDepartments()) {

				for (Employee e : d.getEmployees()) {
					map.putIfAbsent(e.getSex(), new HashMap<Integer, Integer>());
					if (map.containsKey(e.getSex())) {
						if (map.get(e.getSex()).containsKey(e.getAge())) {
							map.get(e.getSex()).put(e.getAge(), map.get(e.getSex()).get(e.getAge())+1);
						}

					}
					map.get(e.getSex()).putIfAbsent(e.getAge(), 1);

				}

			}
		}

		return map;
	}

	public static Map<SexAndAge, Integer> groupEmployeeCountBySexAndAgeUsingCompoundKey(Collection<Company> companies) {
		Map<SexAndAge, Integer> map = new TreeMap<>(new MapComparator());
		for (Company c : companies) {
			for (Department d : c.getDepartments()) {
				for (Employee e : d.getEmployees()) {
					SexAndAge entity = new SexAndAge(e.getSex(), e.getAge());

					if (map.containsKey(entity)) {
						map.put(entity, map.get(entity) + 1);

					}
					map.putIfAbsent(entity, 1);

				}

			}

		}
		// for study purposes
		Integer x = 0;
		for (Integer i : map.values()) {
			x += i;
		}
		System.out.println("There are : " + x + " values ");

		return map;
	}

}
