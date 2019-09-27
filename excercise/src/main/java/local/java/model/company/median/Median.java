package local.java.model.company.median;

import java.util.Collection;
import java.util.List;

public interface Median<T, R extends Number> {

	R get(T item);

	R max(Collection<T> items);

	@SuppressWarnings("unchecked")
	default R getMedian(List<R> items) {
		if (items.size() % 2 == 0) {
			Number m1 = items.get(items.size() / 2);
			Number m2 = items.get((items.size() / 2) - 1);
			Number median = (m1.doubleValue() + m2.doubleValue()) / 2;
			return (R) median;
		} else {
			return items.get(items.size() / 2);
		}
	}
}
