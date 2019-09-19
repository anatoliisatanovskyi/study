package local.java.model;

import java.util.Collection;

public class Department {
	
	private String name;
	private Collection<Employee> employees;

	public Department() {
		super();
	}

	public Department(String name, Collection<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employees=" + employees + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
