package local.java.model.company.rating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import local.java.model.Company;

public class ComplexityRating implements Rating {

	private final Double grade;

	public ComplexityRating(Company company, Collection<Company> competitors) {
		int forCompany = company.getDepartments().size();
		int max = competitors.stream().map(c -> c.getDepartments().size()).mapToInt(v -> v).max().getAsInt();
		this.grade = 10
				- BigDecimal.valueOf(((forCompany * 1.0) / max) * 10).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public double getGrade() {
		return grade;
	}
}
