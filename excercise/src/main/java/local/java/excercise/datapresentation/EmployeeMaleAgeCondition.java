package local.java.excercise.datapresentation;

import java.util.LinkedList;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.Employee;
import local.java.model.Sex;

public class EmployeeMaleAgeCondition implements Condition<Employee> {

	int minAge;

	EmployeeMaleAgeCondition(int minAge) {
		this.minAge = minAge;
	}

	@Override
	public boolean check(Employee entity) {

		return entity.getSex() == Sex.MALE && entity.getAge() >= minAge;
	}

	// todelete

	public static void test() {
	Employee one = EntityGenerator.generateEmployee(new LinkedList<>(), new LinkedList<>());
			
	one.setSex(Sex.MALE);
	System.out.println(one);
	
	Employee two = EntityGenerator.generateEmployee(new LinkedList<>(), new LinkedList<>());
	two.setSex(Sex.FEMALE);
	
	System.out.println(two);
	
	if( one.getSex()==two.getSex()) System.out.println("This is ==");
	if(one.getSex().equals(two.getSex())) System.out.println("This is .equals");
		

		
	}

}
