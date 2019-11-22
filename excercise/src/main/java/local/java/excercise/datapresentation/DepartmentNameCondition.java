package local.java.excercise.datapresentation;

import local.java.model.Department;;

public class DepartmentNameCondition implements Condition<Department> {
	
	String name;
	
	DepartmentNameCondition(String name){
		this.name = name;
	}

	@Override
	public boolean check(Department entity) {
		
		return entity.getName().equals(name);
	}
	
	

}
