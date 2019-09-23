package local.java.excercise.datapresentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompanyView {

	private static <T> List<T> filterWith(Collection<T> entities, Condition<T> condition) {
		List<T> checked = new ArrayList<>();
		for (T entity : entities) {
			if (condition.check(entity)) {
				checked.add(entity);
			}
		}
		return checked;
	}
}
