package local.java.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.excercise.aggregation.Aggregator;

public class AverageComplexityRating implements Rateing {

	private final Double grade;

	public AverageComplexityRating(Company company, Collection<Company> competitors) {
		int forCompany = Aggregator.getDepartmentsCount(company);
		int max = competitors.stream().map(c -> Aggregator.getDepartmentsCount(c)).mapToInt(v -> v).max().getAsInt();
		this.grade = 10 - BigDecimal.valueOf(((forCompany * 1.0) / max) * 10).setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
