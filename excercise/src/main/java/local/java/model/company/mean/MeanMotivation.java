package local.java.model.company.mean;

import java.util.Collection;

import local.java.excercise.aggregation.Aggregator;
import local.java.model.Company;

public class MeanMotivation implements Mean<Company, Double> {

	@Override
	public Double get(Company item) {
		return getMean(Aggregator.getEmployeeSalaries(item));
	}

	@Override
	public Double max(Collection<Company> items) {
		return items.stream().map(this::get).mapToDouble(v -> v).max().getAsDouble();
	}

}
