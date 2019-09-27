package local.java.model.company.mean;

import java.util.Collection;
import java.util.List;

public interface Mean<T, R extends Number> {

	R get(T item);

	R max(Collection<T> items);

	@SuppressWarnings("unchecked")
	default R getMean(List<R> items) {
		Number mean = items.stream().mapToDouble(v -> (Double) v).sum() / items.size();
		return (R) mean;
	}

}
