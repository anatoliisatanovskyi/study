package local.java.excercise.aggregation;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.*;
import java.util.*;
import java.util.Map.Entry;

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

	public static List<Employee> getEmployees(Company company) {
		return getEmployees(company.getDepartments());
	}

	public static List<Employee> getEmployees(Collection<Department> departments) {
		List<Employee> employees = new ArrayList<>();
		for (Department d : departments) {
			employees.addAll(d.getEmployees());
		}
		return employees;
	}

	public static Employee maxSalary(Company company) {
		return maxSalary(company.getDepartments());
	}

	public static Employee maxSalary(Collection<Department> departments) {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		set.addAll(getEmployees(departments));

		return set.last();
	}

	public static double maxSalaryInDepartment(Department d) {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		set.addAll(d.getEmployees());

		return set.last().getSalary();
	}

	public static double minSalaryInDepartment(Department d) {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		set.addAll(d.getEmployees());

		return set.first().getSalary();
	}

	public static Employee minSalary(Company company) {
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		set.addAll(getEmployees(company));

		return set.first();

	}

	public static double avarageSalary(Company company) {
		int allSalary = 0;
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

		return allSalary / workersCount;
	}

	public static double avarageSalarySex(Company company, Sex sex) {
		int allSalary = 0;
		int workersCount = 0;
		List<Double> salaryList = new ArrayList();
		Collection<Department> depCpllectiom = company.getDepartments();
		for (Department d : depCpllectiom) {
			Collection<Employee> employeeCollection = d.getEmployees();
			for (Employee e : employeeCollection) {
				if (e.getSex() == sex) {
					allSalary += e.getSalary();
					workersCount++;
				}
			}
		}
		return allSalary / workersCount;
	}

	public static Map countEmployeeInDepartaments(List<Company> company) {
		Map<String, List<String>> map = new HashMap();
		Map<String, Integer> ResultMap = new HashMap();
		// Gethering all employee Names in all companies by Department name
		for (Company c : company) {
			Collection<Department> d = c.getDepartments();
			for (Department dep : d) {
				Collection<Employee> employee = dep.getEmployees();
				for (Employee e : employee) {
					map.putIfAbsent(dep.getName(), new ArrayList<>());
					map.get(dep.getName()).add(e.getFirstName());
				}
			}
		}
		System.out.println("First Map: " + map);
		// map.entrySet().forEach(System.out::println);

		Set s1 = map.entrySet();
		Iterator itr = s1.iterator();
		while (itr.hasNext()) {
			int before = 0;
			int after = 0;
			Map.Entry<String, List<String>> m1 = (Map.Entry) itr.next();
			Set<String> employeeHash = new HashSet<>();
			before = m1.getValue().size();
			System.out.println("Before: " + before);
			employeeHash.addAll(m1.getValue());
			after = employeeHash.size();
			System.out.println("After: " + after);
			ResultMap.put(m1.getKey(), (before - after));
		}
		ResultMap.entrySet().forEach(System.out::println);

		return ResultMap;
	}

	public static Map countEmployeeInDepartaments(Company company) {
		Map<String, Integer> map = new HashMap();
		List<Department> d = new ArrayList(company.getDepartments());
		for (Department dep : d) {
			int size = 0;
			size = dep.getEmployees().size();
			map.put(dep.getName(), size);
		}
		map.entrySet().forEach(System.out::println);

		return map;
	}

	public static Map maxSallaryInDepartments(Company company) {

		Map<String, Double> map = new HashMap();
		List<Department> d = new ArrayList(company.getDepartments());
		for (Department dep : d) {
			double maxSalary = 0;
			maxSalary = maxSalaryInDepartment(dep);
			map.put(dep.getName(), maxSalary);
		}
		map.entrySet().forEach(System.out::println);

		return map;
	}

	public static Map minSallaryInDepartments(Company company) {

		Map<String, Double> map = new HashMap();
		List<Department> d = new ArrayList<>(company.getDepartments());
		for (Department dep : d) {
			double minSalary = 0;
			minSalary = minSalaryInDepartment(dep);
			map.put(dep.getName(), minSalary);
		}
		return map;
	}

	public static int TolminSallaryInDepartments(Company company, String departmentName) {
		Map<String, Double> map = (minSallaryInDepartments(company));
		if (map.get(departmentName) == null) {
			return 0;
		} else
			return (int) Math.round(map.get(departmentName));
	}

}
