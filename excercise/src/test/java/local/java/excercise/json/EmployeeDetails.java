package local.java.excercise.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.java.model.Employee;

public class EmployeeDetails implements Jsonifiable {

	String companyName;
	String departmentName;
	Employee employee;
	public EmployeeDetails(String companyName, String departmentName, Employee employee) {
		super();
		this.companyName = companyName;
		this.departmentName = departmentName;
		this.employee = employee;
	}
	
	public EmployeeDetails() {
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	@Override
	public String toString() {
		return "EmployeeDetails [companyName=" + companyName + ", departmentName=" + departmentName + ", employee="
				+ employee + "]";
	}

	@Override
	public String toJson() throws JsonParseException {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new JsonParseException("Couldn't translate object", e);
		}
	}
	
	
	
}
