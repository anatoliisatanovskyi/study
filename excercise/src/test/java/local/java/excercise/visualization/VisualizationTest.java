package local.java.excercise.visualization;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import local.java.excercise.aggregation.Aggregator;
import local.java.excercise.composition.EntityGenerator;
import local.java.excercise.filesio.LinesWriter;
import local.java.model.Company;
import local.java.model.CompanyRateing;
import local.java.model.Employee;
import local.java.model.RateingType;

public class VisualizationTest {

	@Test
	public void testCompanyEmployeeSalary() throws Exception {
		
		Company company = EntityGenerator.generateCompany();
		List<Employee> employees = Aggregator.getCompanyEmployees(company).stream()
				.sorted((c1, c2) -> c2.getSalary().compareTo(c1.getSalary())).limit(25).collect(Collectors.toList());

		List<String> lines = new ArrayList<>();
		lines.add("name,salary");
		lines.addAll(employees.stream().map(e -> {
			return String.format("%s %s,%.2f", e.getFirstName(), e.getLastName(), e.getSalary());
		}).collect(Collectors.toList()));

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("salary.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "salary.html");
	}

	@Test
	public void testCompanyEmployeeAge() throws Exception {
		Company company = EntityGenerator.generateCompany();
		List<Employee> employees = Aggregator.getCompanyEmployees(company);

		int maxSize = 20;
		if (employees.size() > maxSize)
			employees = employees.subList(0, maxSize);

		employees = employees.stream().sorted((c1, c2) -> c2.getAge().compareTo(c1.getAge()))
				.collect(Collectors.toList());

		List<String> lines = new ArrayList<>();
		lines.add("name,age");
		lines.addAll(employees.stream().map(e -> {
			return String.format("%s %s,%d", e.getFirstName(), e.getLastName(), e.getAge());
		}).collect(Collectors.toList()));

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("age.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "age.html");
	}

	@Test
	public void testCompanyRatings() throws Exception {

		Collection<Company> companies = IntStream.range(0, 20).boxed().map(stub -> EntityGenerator.generateCompany())
				.collect(Collectors.toList());

		Collection<CompanyRateing> rateings = companies.stream().map(c -> {
			return new CompanyRateing(c.getName(), RateingType.SIZE_AVERAGE.createFor(c, companies),
					RateingType.MOTIVATION_AVERAGE.createFor(c, companies),
					RateingType.COMPLEXITY_AVERAGE.createFor(c, companies));
		}).collect(Collectors.toList());

		List<String> lines = new ArrayList<>();
		lines.add("name,size,motivation,complexity");
		lines.addAll(rateings.stream().map(cr -> String.format("%s,%.2f,%.2f,%.2f", cr.getName(), cr.getSize(),
				cr.getMotivation(), cr.getComplexity())).collect(Collectors.toList()));

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("ratings.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "ratings.html");
	}

	private String resourceRootPath() {
		return new StringBuilder()
				.append(new File(this.getClass().getClassLoader().getResource(".").getFile()).getParentFile()
						.getParentFile().getAbsolutePath())
				.append(File.separator).append("src").append(File.separator).append("main").append(File.separator)
				.append("resources").toString();
	}
}
