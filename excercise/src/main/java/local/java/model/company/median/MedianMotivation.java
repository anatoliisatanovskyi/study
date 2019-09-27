package local.java.model.company.median;

import java.util.Collection;

import local.java.excercise.aggregation.Aggregator;
import local.java.model.Company;

public class MedianMotivation implements Median<Company, Double> {

	@Override
	public Double get(Company item) {
		return getMedian(Aggregator.getEmployeeSalaries(item));
	}

	@Override
	public Double max(Collection<Company> items) {
		return items.stream().map(this::get).mapToDouble(v -> v).max().getAsDouble();
	}
}
