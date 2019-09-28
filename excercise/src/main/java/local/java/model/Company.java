package local.java.model;

import java.util.Collection;

public class Company {
	
	private String name;
	private Collection<Department> departments;

	public Company() {
		super();
	}

	public Company(String name, Collection<Department> departments) {
		this.name = name;
		this.departments = departments;
	}

	
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", departments=" + departments + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
	}

}
