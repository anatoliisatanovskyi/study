package local.java.excercise.datapresentation;

import local.java.model.Employee;

import local.java.model.Sex;

public class EmployeeSexAgeComdotionFrom_To implements Condition<Employee> {

	int from;
	int to;
	Sex sex;

	public EmployeeSexAgeComdotionFrom_To(int from, int to, Sex sex) {
		super();
		this.from = from;
		this.to = to;
		this.sex = sex;
	}

	@Override
	public boolean check(Employee entity) {
	
		return entity.getSex().equals(sex) && entity.getAge() >= from && entity.getAge()<= to;
	}

}
