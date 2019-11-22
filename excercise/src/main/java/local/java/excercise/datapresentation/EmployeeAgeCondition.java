package local.java.excercise.datapresentation;

import local.java.model.Employee;

public class EmployeeAgeCondition implements Condition<Employee> {

	int maxAge;

	EmployeeAgeCondition(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public boolean check(Employee entity) {
		return entity.getAge() <= maxAge;
	}

}
