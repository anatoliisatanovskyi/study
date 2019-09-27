package local.java.model.company.rating;

import java.util.Collection;

import local.java.model.Company;
import local.java.model.company.mean.MedianMotivationRating;
import local.java.model.company.median.MeanMotivationRating;

public enum RatingType {
	
	SIZE {
		@Override
		public Rating createFor(Company company, Collection<Company> competitors) {
			return new SizeRating(company, competitors);
		}
	},
	MOTIVATION_MEAN {
		@Override
		public Rating createFor(Company company, Collection<Company> competitors) {
			return new MeanMotivationRating(company, competitors);
		}
	},
	MOTIVATION_MEDIAN {
		@Override
		public Rating createFor(Company company, Collection<Company> competitors) {
			return new MedianMotivationRating(company, competitors);
		}
	},
	COMPLEXITY {
		@Override
		public Rating createFor(Company company, Collection<Company> competitors) {
			return new ComplexityRating(company, competitors);
		}
	};

	public abstract Rating createFor(Company company, Collection<Company> competitors);
}
