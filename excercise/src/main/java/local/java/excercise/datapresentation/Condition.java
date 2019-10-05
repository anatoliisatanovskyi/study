package local.java.excercise.datapresentation;

import local.java.model.Employee;

public interface Condition<T> {

	boolean check(T entity);

}
