package local.java.model.company.median;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.model.Company;
import local.java.model.company.mean.MeanMotivation;
import local.java.model.company.rating.Rating;

public class MeanMotivationRating implements Rating {

	private final Double grade;

	public MeanMotivationRating(Company company, Collection<Company> companies) {
		MeanMotivation meanMotivation = new MeanMotivation();
		this.grade = BigDecimal.valueOf((meanMotivation.get(company) / meanMotivation.max(companies)) * 10)
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
