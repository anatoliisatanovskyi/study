package local.java.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.excercise.aggregation.Aggregator;

public class AverageSizeRating implements Rateing {

	private final Double grade;

	public AverageSizeRating(Company company, Collection<Company> competitors) {
		double forCompany = Aggregator.getEmployeeCount(company);
		int max = competitors.stream().map(c -> Aggregator.getEmployeeCount(c)).mapToInt(v -> v).max().getAsInt();
		this.grade = BigDecimal.valueOf((forCompany / max) * 10).setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
