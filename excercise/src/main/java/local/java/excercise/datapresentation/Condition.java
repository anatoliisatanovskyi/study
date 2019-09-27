package local.java.excercise.datapresentation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Condition<T> {

	boolean check(T entity);

	default List<T> filter(Collection<T> items) {
		return items.stream().filter(this::check).collect(Collectors.toList());
	}
}
