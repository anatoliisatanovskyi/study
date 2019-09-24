package local.java.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.excercise.aggregation.Aggregator;

public class AverageMotivationRating implements Rateing {

	private final Double grade;

	public AverageMotivationRating(Company company, Collection<Company> competitors) {
		double max = competitors.stream().map(c -> Aggregator.getAverageSalary(c)).mapToDouble(v -> v).max().getAsDouble();
		this.grade = BigDecimal
				.valueOf((Aggregator.getAverageSalary(company) / max) * 10)
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
