package local.java.excercise.visualization;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import local.java.excercise.aggregation.Aggregator;
import local.java.excercise.composition.EntityGenerator;
import local.java.excercise.filesio.LinesWriter;
import local.java.model.Company;
import local.java.model.CompanyRateing;
import local.java.model.Department;
import local.java.model.Employee;
import local.java.model.company.rating.RatingType;

public class VisualizationTest {

	@Test
	public void testCompanyEmployeeSalary() throws Exception {

		Company company = EntityGenerator.generateCompany();
		List<Employee> employees = Aggregator.getCompanyEmployees(company).stream()
				.sorted((c1, c2) -> c1.getSalary().compareTo(c2.getSalary())).collect(Collectors.toList());

		List<String> lines = Stream
				.concat(Arrays.asList("name,salary".split(",")).stream(), employees.stream().map(e -> {
					return String.format("%s %s,%.2f", e.getFirstName(), e.getLastName(), e.getSalary());
				})).collect(Collectors.toList());

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("salary.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "salary.html");
	}

	@Test
	public void testCompanyEmployeeAge() throws Exception {

		Company company = EntityGenerator.generateCompany();
		List<Employee> employees = Aggregator.getCompanyEmployees(company).stream()
				.sorted((c1, c2) -> c1.getAge().compareTo(c2.getAge())).collect(Collectors.toList());

		List<String> lines = Stream.concat(Arrays.asList("name,age".split(",")).stream(), employees.stream().map(e -> {
			return String.format("%s %s,%.2f", e.getFirstName(), e.getLastName(), e.getSalary());
		})).collect(Collectors.toList());

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("age.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "age.html");
	}

	@Test
	public void testCompanyRatings() throws Exception {

		Collection<Company> companies = IntStream.range(0, 5).boxed().map(stub -> EntityGenerator.generateCompany())
				.collect(Collectors.toList());

		Collection<CompanyRateing> rateings = companies.stream().map(c -> {
			return CompanyRateing.builder().name(c.getName())//
					.size(RatingType.SIZE.createFor(c, companies))//
					.complexity(RatingType.COMPLEXITY.createFor(c, companies))//
					.meanMotivation(RatingType.MOTIVATION_MEAN.createFor(c, companies))
					.medianMotivation(RatingType.MOTIVATION_MEDIAN.createFor(c, companies)).build();
		}).collect(Collectors.toList());

		List<String> lines = Stream
				.concat(Arrays.asList("name,size,complexity,meanMotivation,medianMotivation".split(",")).stream(),
						rateings.stream()
								.map(cr -> String.format("%s,%.2f,%.2f,%.2f,%.2f", cr.getName(), cr.getSize(),
										cr.getComplexity(), cr.getMeanMotivation(), cr.getMedianMotivation())))
				.collect(Collectors.toList());

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("ratings.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "ratings.html");
	}

	@Test
	public void testAverageSalaryByAge() throws Exception {
		Company company = EntityGenerator.generateCompany();
		Map<Integer, List<Double>> salaryByAge = new TreeMap<>();
		for (Department department : company.getDepartments()) {
			for (Employee employee : department.getEmployees()) {
				salaryByAge.putIfAbsent(employee.getAge(), new ArrayList<>());
				salaryByAge.get(employee.getAge()).add(employee.getSalary());
			}
		}

		List<String> lines = new ArrayList<>();
		lines.add("age,salary");
		lines.addAll(salaryByAge.entrySet().stream().map(e -> {
			return String.format("%d,%.2f", e.getKey(),
					e.getValue().stream().mapToDouble(v -> v).average().getAsDouble());
		}).collect(Collectors.toList()));

		String path = new StringBuilder().append(resourceRootPath()).append(File.separator).append("web")
				.append(File.separator).append("age-salary.csv").toString();

		LinesWriter.writeNew(path, lines);

		System.out.println(resourceRootPath() + File.separator + "web" + File.separator + "age-salary.html");
	}

	private String resourceRootPath() {
		return new StringBuilder()
				.append(new File(this.getClass().getClassLoader().getResource(".").getFile()).getParentFile()
						.getParentFile().getAbsolutePath())
				.append(File.separator).append("src").append(File.separator).append("main").append(File.separator)
				.append("resources").toString();
	}
}
