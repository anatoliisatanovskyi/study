package local.java.model;

import local.java.model.company.rating.Rating;

public class CompanyRateing {

	private final String name;
	private final Rating size;
	private final Rating complexity;
	private final Rating meanMotivation;
	private final Rating medianMotivation;

	private CompanyRateing(String name, Rating size, Rating complexity, Rating meanMotivation, Rating medianMotivation) {
		this.name = name;
		this.size = size;
		this.complexity = complexity;
		this.meanMotivation = meanMotivation;
		this.medianMotivation = medianMotivation;
	}

	public String getName() {
		return name;
	}

	public double getSize() {
		return size.getGrade();
	}

	public double getComplexity() {
		return complexity.getGrade();
	}

	public double getMeanMotivation() {
		return meanMotivation.getGrade();
	}

	public double getMedianMotivation() {
		return medianMotivation.getGrade();
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String name;
		private Rating size;
		private Rating complexity;
		private Rating meanMotivation;
		private Rating medianMotivation;

		public CompanyRateing build() {
			return new CompanyRateing(name, size, complexity, meanMotivation, medianMotivation);
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder size(Rating size) {
			this.size = size;
			return this;
		}

		public Builder complexity(Rating complexity) {
			this.complexity = complexity;
			return this;
		}

		public Builder meanMotivation(Rating meanMotivation) {
			this.meanMotivation = meanMotivation;
			return this;
		}

		public Builder medianMotivation(Rating medianMotivation) {
			this.medianMotivation = medianMotivation;
			return this;
		}
	}
}
