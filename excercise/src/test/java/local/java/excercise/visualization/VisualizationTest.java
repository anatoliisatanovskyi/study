package local.java.excercise.visualization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import local.java.excercise.composition.EntityGenerator;
import local.java.model.Company;
import local.java.model.CompanyRateing;
import local.java.model.RateingType;

public class VisualizationTest {

	@Test
	public void testCompanyRatings() throws Exception {

		Collection<Company> companies = IntStream.range(0, 20).boxed().map(stub -> EntityGenerator.generateCompany())
				.collect(Collectors.toList());

		Collection<CompanyRateing> rateings = companies.stream().map(c -> {
			return new CompanyRateing(c.getName(), RateingType.SIZE_AVERAGE.createFor(c, companies),
					RateingType.MOTIVATION_AVERAGE.createFor(c, companies),
					RateingType.COMPLEXITY_AVERAGE.createFor(c, companies));
		}).collect(Collectors.toList());

		List<String> lines = rateings.stream().map(cr -> String.format("%s,%.2f,%.2f,%.2f", cr.getName(), cr.getSize(),
				cr.getMotivation(), cr.getComplexity())).collect(Collectors.toList());

		String resourcesRoot = new StringBuilder()
				.append(new File(this.getClass().getClassLoader().getResource(".").getFile()).getParentFile()
						.getParentFile().getAbsolutePath())
				.append(File.separator).append("src").append(File.separator).append("main").append(File.separator)
				.append("resources").toString();

		String path = new StringBuilder().append(resourcesRoot).append(File.separator).append("web")
				.append(File.separator).append("grades.csv").toString();

		writeLines(path, lines);

		System.out.printf("html link:%s", resourcesRoot + File.separator + "web" + File.separator + "index.html");
	}

	private void writeLines(String path, Collection<String> lines) throws IOException {

		recreateFile(path);

		try (FileWriter fw = new FileWriter(path)) {
			fw.write("name,size,motivation,complexity\n");
			for (String line : lines) {
				fw.write(line + "\n");
			}
		}
	}

	private void recreateFile(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
	}

}
