package local.java.excercise.datapresentation;

import local.java.model.Employee;
import local.java.model.Sex;;

public class EmployeeFemaleCondition implements Condition<Employee> {

	
	@Override
	public boolean check(Employee entity) {
		
		return entity.getSex() == Sex.FEMALE;
	}
	

}
