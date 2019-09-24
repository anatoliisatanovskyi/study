package local.java.model;

import java.util.Collection;

public enum RateingType {
	
	SIZE_AVERAGE {
		@Override
		public Rateing createFor(Company company, Collection<Company> competitors) {
			return new AverageSizeRating(company, competitors);
		}
	},
	MOTIVATION_AVERAGE {
		@Override
		public Rateing createFor(Company company, Collection<Company> competitors) {
			return new AverageMotivationRating(company, competitors);
		}
	},
	COMPLEXITY_AVERAGE {
		@Override
		public Rateing createFor(Company company, Collection<Company> competitors) {
			return new AverageComplexityRating(company, competitors);
		}
	};

	public abstract Rateing createFor(Company company, Collection<Company> competitors);
}
