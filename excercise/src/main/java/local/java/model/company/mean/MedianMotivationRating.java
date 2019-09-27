package local.java.model.company.mean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.model.Company;
import local.java.model.company.median.MedianMotivation;
import local.java.model.company.rating.Rating;

public class MedianMotivationRating implements Rating {

	private final Double grade;

	public MedianMotivationRating(Company company, Collection<Company> companies) {
		MedianMotivation medianMotivation = new MedianMotivation();
		this.grade = BigDecimal.valueOf((medianMotivation.get(company) / medianMotivation.max(companies)) * 10)
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
