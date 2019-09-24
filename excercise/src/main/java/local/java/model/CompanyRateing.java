package local.java.model;

public class CompanyRateing implements Rateing {

	private final String name;
	private final Rateing size;
	private final Rateing motivation;
	private final Rateing complexity;

	public CompanyRateing(String name, Rateing size, Rateing motivation, Rateing complexity) {
		this.name = name;
		this.size = size;
		this.motivation = motivation;
		this.complexity = complexity;
	}

	@Override
	public double getGrade() {
		return (size.getGrade() + motivation.getGrade() + complexity.getGrade()) / 3;
	}

	public String getName() {
		return name;
	}

	public double getSize() {
		return size.getGrade();
	}

	public double getMotivation() {
		return motivation.getGrade();
	}

	public double getComplexity() {
		return complexity.getGrade();
	}
}
